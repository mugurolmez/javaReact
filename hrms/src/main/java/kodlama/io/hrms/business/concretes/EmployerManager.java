package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.dtos.requests.AddEmployerRequest;
import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllJobSeekersResponse;
import kodlama.io.hrms.business.rules.concretes.EmployerBusinessRules;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.EmployerDao;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import kodlama.io.hrms.entities.Employer;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.Person;
import kodlama.io.hrms.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    private ModelMapperService modelMapperService;
    private EmailService emailService;
    private EmployerBusinessRules employerBusinessRules;
    @Autowired
    public EmployerManager(EmployerDao employerDao,EmployerBusinessRules employerBusinessRules ,ModelMapperService modelMapperService,EmailService emailService) {
        this.employerDao = employerDao;
        this.modelMapperService=modelMapperService;
        this.emailService=emailService;
        this.employerBusinessRules=employerBusinessRules;
    }

    @Override
    public Result add(AddEmployerRequest addEmployerRequest) {
        String emailDomain = addEmployerRequest.getEmail().substring(addEmployerRequest.getEmail().lastIndexOf("@") + 1);
        String websiteDomain = addEmployerRequest.getWebSite().toLowerCase().replaceFirst("^(www\\.|http://)", "");
        if (!emailDomain.equalsIgnoreCase(websiteDomain)) {
            return new ErrorResult("Email adresi ve şirket web sitesi aynı domainde olmalı");
        }

        if(this.employerBusinessRules.checkIfEmployerEmailExists(addEmployerRequest.getEmail())){
            return new ErrorResult("Bu E-posta adresı zaten kullanılıyor");
        }



        User user = this.modelMapperService.forRequest().map(addEmployerRequest,User.class);
        Employer employer = this.modelMapperService.forRequest().map(addEmployerRequest, Employer.class);
        employer.setUser(user);
        employer.setApprovalStatus(false);
            this.employerDao.save(employer);
            this.emailService.sendVerificationEmail(addEmployerRequest.getEmail());
            return new SuccessResult(addEmployerRequest.getEmail() + " Adresine Doğrulama Maili Gönderildi.");


    }

    @Override
    public List<GetAllEmployersResponse> getAll() {
        List<Employer> employers =employerDao.findAll();

        List<GetAllEmployersResponse> employersResponses=employers.stream()
                .map(employer->this.modelMapperService.forResponse()
                        .map(employer, GetAllEmployersResponse.class)).collect(Collectors.toList());
        return employersResponses;
    }
}
