package kodlama.io.hrms.business.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
     void sendVerificationEmail(String email);
}
