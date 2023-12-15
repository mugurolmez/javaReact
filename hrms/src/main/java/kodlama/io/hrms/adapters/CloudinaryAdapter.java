package kodlama.io.hrms.adapters;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.transaction.Transactional;
import kodlama.io.hrms.business.abstracts.CloudinaryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class CloudinaryAdapter implements CloudinaryService {
    @Autowired
    private final Cloudinary cloudinary;


    public Map<?, ?> upload(MultipartFile multipartFile) throws IOException {

        File file = convert(multipartFile);
        Map<?, ?> result = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

        if (!Files.deleteIfExists(file.toPath())) {
            throw new IOException("Failed to delete temporary file: " + file.getAbsolutePath());
        }

        return result;
    }

    public Map<?, ?> delete(String id) throws IOException {
        return this.cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
