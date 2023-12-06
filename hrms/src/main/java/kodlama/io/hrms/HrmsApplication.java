package kodlama.io.hrms;


import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.IOException;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories("kodlama.io.hrms.dataAcces")
public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);


	}


	@Bean
	public Cloudinary getCloudinary(){
		return new Cloudinary();
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	// Set your Cloudinary credentials

}
