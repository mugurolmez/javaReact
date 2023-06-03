package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.adapters.PersonCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class JobSeekerManager implements JobSeekerService {
    @Autowired
    private JobSeekerDao jobSeekerDao;
    @Autowired
    private PersonCheckService personCheckService;
    @Autowired
    private EmailService emailService;
    //ikisinede @Autowired yazmayınca hata veriyor

    public JobSeekerManager(EmailService emailService) {
        this.emailService = emailService;
    }

    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    public JobSeekerManager(PersonCheckService personCheckService) {
        this.personCheckService = personCheckService;
    }

    //mail servisi simüle edildi
    @Override
    public Result add(JobSeeker jobSeeker) {
        if(this.personCheckService.CheckIfRealJobSeeker(jobSeeker)){
            this.jobSeekerDao.save(jobSeeker);
            this.emailService.sendVerificationEmail(jobSeeker);;
            return new SuccessResult("İş Arayan Eklendi "+jobSeeker.getPerson().getUser().getEmail()+" Adresine Doğrulama Maili Gönderildi");
        }else{

            return new ErrorResult("İş Arayan Doğrulanamadı");
        }

    }

    @Override
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }


}
