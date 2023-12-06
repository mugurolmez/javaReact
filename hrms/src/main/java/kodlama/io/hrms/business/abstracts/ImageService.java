package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ImageService {

    List<Image> list();


    Optional<Image> getOne(int id);

    Result add(int jobSeekerId, MultipartFile multipartFile) throws IOException;
    
    void delete(int id);

    boolean exists(int id);
}
