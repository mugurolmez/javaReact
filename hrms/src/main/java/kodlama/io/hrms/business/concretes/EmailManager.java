package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    @Override
    public void sendVerificationEmail(String email) {
        System.out.println("Doğrumala maili gönderildi");
    }
}
