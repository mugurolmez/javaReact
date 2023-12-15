package kodlama.io.hrms.business.concretes;

import jakarta.transaction.Transactional;
import kodlama.io.hrms.business.abstracts.CloudinaryService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.business.dtos.responses.GetAllImagesResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.ImageDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.cvEntities.Image;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ImageManager implements ImageService {
    @Autowired
    ImageDao imageDao;
    CloudinaryService cloudinaryService;
    JobSeekerDao jobSeekerDao;
    ModelMapperService modelMapperService;

    public List<GetAllImagesResponse> getAll() {

        List<Image> images = imageDao.findAll();

        List<GetAllImagesResponse> imagesResponses = images.stream()
                .map(image -> this.modelMapperService.forResponse()
                        .map(image, GetAllImagesResponse.class))
                .collect(Collectors.toList());
        return imagesResponses;

    }

    public Optional<Image> getOne(int id) {
        return this.imageDao.findById(id);
    }

    public Result add(int jobSeekerId, MultipartFile multipartFile) throws IOException {
        // Gelen multipart dosyasını bir BufferedImage'a okuyoruz.
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());

        // Eğer bi null ise, geçersiz bir resim geldi demektir.
        if (bi == null) {
            return new ErrorResult("Resim geçerli değil!");
        }

        Optional<JobSeeker> optionalJobSeeker = jobSeekerDao.findById(jobSeekerId);

        if (optionalJobSeeker.isEmpty()) {
            return new ErrorResult("JobSeeker geçerli değil!");
        }
        if (imageDao.existsByJobSeeker_JobSeekerId(jobSeekerId)) {
            return new ErrorResult("Kayıtlı resim var");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();

        // Cloudinary servisi üzerinden dosyayı yükleyip sonucu alıyoruz.
        Map<?, ?> result = cloudinaryService.upload(multipartFile);

        // Cloudinary'den gelen sonuçları kullanarak yeni bir Image nesnesi oluşturuyoruz.
        Image image = new Image(
                (String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"),
                jobSeeker
        );


        this.imageDao.save(image);

        return new SuccessResult("Kayıt Başarılı");
    }

    public void delete(int id) {


        this.imageDao.deleteById(id);
    }


    public boolean exists(int id) {
        return this.imageDao.existsById(id);
    }
}
