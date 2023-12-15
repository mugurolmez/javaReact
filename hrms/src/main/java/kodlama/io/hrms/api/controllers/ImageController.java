package kodlama.io.hrms.api.controllers;

import jakarta.transaction.Transactional;
import kodlama.io.hrms.business.abstracts.CloudinaryService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.business.dtos.responses.GetAllImagesResponse;
import kodlama.io.hrms.entities.cvEntities.Image;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ImageController {
    @Autowired
    private CloudinaryService cloudinaryService;
    private ImageService imageService;


    @GetMapping("/getAllImagesResponse")
    List<GetAllImagesResponse> getAll() {
        return this.imageService.getAll();

    }

    //postederken yaparken postmande http://localhost:8080/image/upload
    //post-body-form-data secip key=multipartFile file seçip resmin kısa yolu seçiliyor.

    @Transactional
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestParam int jobSeekerId, MultipartFile multipartFile) throws IOException {

        return ResponseEntity.ok(this.imageService.add(jobSeekerId, multipartFile));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Image> imageOptional = imageService.getOne(id);
        if (imageOptional.isEmpty()) {
            return new ResponseEntity<>("resim bulunamadı", HttpStatus.NOT_FOUND);
        }
        Image image = imageOptional.get();
        String cloudinaryImageId = image.getImageId();
        try {
            cloudinaryService.delete(cloudinaryImageId);
        } catch (IOException e) {
            return new ResponseEntity<>("resim Cloudinaryden silinemedi", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        imageService.delete(id);
        return new ResponseEntity<>("resim silindi", HttpStatus.OK);
    }
}
