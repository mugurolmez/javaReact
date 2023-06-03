package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
     void sendVerificationEmail(JobSeeker jobSeeker);
}
