package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobSeekersResponse;
import kodlama.io.hrms.business.rules.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.business.rules.concretes.JobSeekerBusinessRules;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.Person;
import kodlama.io.hrms.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private JobSeekerCheckService jobSeekerCheckService;
    private EmailService emailService;
    private ModelMapperService modelMapperService;
    private JobSeekerBusinessRules jobSeekerBusinessRules;




    //mail servisi simüle edildi
    @Override
    public Result add(AddJobSeekerRequest addJobSeekerRequest) {


        if(jobSeekerBusinessRules.checkIfJobseekerEmailExists(addJobSeekerRequest.getEmail())){
            return new ErrorResult("Bu E-posta adresı Kullanılıyor");
        }
        if(jobSeekerBusinessRules.checkIfJobSeekerNationalityNumber(addJobSeekerRequest.getNationalityNumber())){
            return new ErrorResult("Bu Tc Kimlik Numarası Kullanılıyor");
        }

        if (this.jobSeekerCheckService.CheckIfRealJobSeeker(addJobSeekerRequest)) {
            User user = this.modelMapperService.forRequest().map(addJobSeekerRequest, User.class);
            Person person = this.modelMapperService.forRequest().map(addJobSeekerRequest, Person.class);
            JobSeeker jobSeeker = this.modelMapperService.forRequest().map(addJobSeekerRequest, JobSeeker.class);
            person.setUser(user);
            jobSeeker.setUser(user);
            jobSeeker.setPerson(person);

            this.jobSeekerDao.save(jobSeeker);
            this.emailService.sendVerificationEmail(addJobSeekerRequest.getEmail());

            return new SuccessResult("İş Arayan Eklendi " + addJobSeekerRequest.getEmail() + " Adresine Doğrulama Maili Gönderildi");
        } else
            return new ErrorResult();
    }

    @Override
    public List<GetAllJobSeekersResponse> getAll() {

        List<JobSeeker> jobSeekers = jobSeekerDao.findAll();

        List<GetAllJobSeekersResponse> jobSeekerResponses = jobSeekers.stream()
                .map(jobseeker -> this.modelMapperService.forResponse()
                        .map(jobseeker, GetAllJobSeekersResponse.class))
                .collect(Collectors.toList());
        return jobSeekerResponses;

    }


}
