package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
@Service
public interface CloudinaryService {
    Map<?,?>  upload(MultipartFile multipartFile) throws IOException;
    Map<?,?> delete(String id) throws IOException;
    File convert(MultipartFile multipartFile) throws IOException;
}
