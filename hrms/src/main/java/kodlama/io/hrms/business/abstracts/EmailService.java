package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    public void UserVerificationEmailService(User user);
}
