package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    @Override
    public void UserVerificationEmailService(User user) {
        System.out.println(user.getEmail()+" Adresine Doğrulama Maili Gönderildi ");
    }
}
