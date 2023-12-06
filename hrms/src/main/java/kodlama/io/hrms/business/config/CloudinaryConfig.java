package kodlama.io.hrms.business.config;

import com.cloudinary.Cloudinary;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(Dotenv dotenv) {
        String cloudinaryUrl = dotenv.get("CLOUDINARY_URL").replaceAll("[<>]", "");
        Cloudinary cloudinary = new Cloudinary(cloudinaryUrl);
        cloudinary.config.secure = true;
        System.out.println(cloudinary.config.cloudName);
        return cloudinary;
    }
}
