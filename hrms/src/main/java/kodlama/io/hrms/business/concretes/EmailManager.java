package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    @Override
    public void sendVerificationEmail(JobSeeker jobSeeker) {
        System.out.println("Doğrumala maili gönderildi");
    }
}
