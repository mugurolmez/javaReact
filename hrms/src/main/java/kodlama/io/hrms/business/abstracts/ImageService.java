package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.responses.GetAllImagesResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.cvEntities.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ImageService {

    List<GetAllImagesResponse> getAll();

    Optional<Image> getOne(int id);

    Result add(int jobSeekerId, MultipartFile multipartFile) throws IOException;

    void delete(int id);

    boolean exists(int id);
}
