package kodlama.io.hrms.business.concretes;

import jakarta.transaction.Transactional;
import kodlama.io.hrms.adapters.CloudinaryAdapter;
import kodlama.io.hrms.business.abstracts.CloudinaryService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.ImageRepository;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.Image;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional

public class ImageManager implements ImageService {
    @Autowired
    ImageRepository imageRepository;
    CloudinaryService cloudinaryService;
    JobSeekerDao jobSeekerDao;

    public ImageManager(ImageRepository imageRepository, CloudinaryService cloudinaryService, JobSeekerDao jobSeekerDao) {
        this.imageRepository = imageRepository;
        this.cloudinaryService = cloudinaryService;
        this.jobSeekerDao = jobSeekerDao;
    }

    public List<Image> list() {
        return this.imageRepository.findByOrderById();
    }

    public Optional<Image> getOne(int id) {
        return this.imageRepository.findById(id);
    }

    public Result add(int jobSeekerId,MultipartFile multipartFile) throws IOException {
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
        if (imageRepository.existsByJobSeeker_JobSeekerId(jobSeekerId)) {
            return new  ErrorResult( "Kayıtlı resim var");
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


        this.imageRepository.save(image);

        return new SuccessResult("Kayıt Başarılı");
    }

    public void delete(int id) {


        this.imageRepository.deleteById(id);
    }


    public boolean exists(int id) {
        return this.imageRepository.existsById(id);
    }
}
