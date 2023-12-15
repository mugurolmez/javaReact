package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.EmployerVerifyService;
import kodlama.io.hrms.business.abstracts.HrmsPersonService;
import kodlama.io.hrms.business.dtos.requests.AddEmployerVerifyRequest;
import kodlama.io.hrms.business.dtos.requests.AddHrmsPersonRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllHrmsPersonResponse;

import kodlama.io.hrms.business.rules.concretes.HrmsPersonBusinessRules;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.*;
import kodlama.io.hrms.entities.*;
import kodlama.io.hrms.entities.userEntities.Employer;
import kodlama.io.hrms.entities.userEntities.HrmsPerson;
import kodlama.io.hrms.entities.userEntities.Person;
import kodlama.io.hrms.entities.userEntities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HrmsPersonManager implements HrmsPersonService {
    @Autowired
    private HrmsPersonDao hrmsPersonDao;
    private EmailService emailService;
    private ModelMapperService modelMapperService;
    private HrmsPersonBusinessRules hrmsPersonBusinessRules;
    private TemporaryEmployerDao temporaryEmployerDao;
    private EmployerDao employerDao;
    private UserDao userDao;
    private EmployerVerifyService employerVerifyService;


    @Override
    public Result add(AddHrmsPersonRequest addHrmsPersonRequest) {

        if (hrmsPersonBusinessRules.checkIfHrmsPersonEmailExists(addHrmsPersonRequest.getEmail())) {
            return new ErrorResult("Bu E-posta adresı Kullanılıyor");
        }
        if (hrmsPersonBusinessRules.checkIfHrmsPersonNationalityNumber(addHrmsPersonRequest.getNationalityNumber())) {
            return new ErrorResult("Bu Tc Kimlik Numarası Kullanılıyor");
        }


        User user = this.modelMapperService.forRequest().map(addHrmsPersonRequest, User.class);
        Person person = this.modelMapperService.forRequest().map(addHrmsPersonRequest, Person.class);
        HrmsPerson hrmsPerson = this.modelMapperService.forRequest().map(addHrmsPersonRequest, HrmsPerson.class);
        person.setUser(user);
        hrmsPerson.setUser(user);
        hrmsPerson.setPerson(person);

        this.hrmsPersonDao.save(hrmsPerson);
        this.emailService.sendVerificationEmail(addHrmsPersonRequest.getEmail());

        return new SuccessResult("Hrms Personeli Eklendi " + addHrmsPersonRequest.getEmail());


    }

    @Override
    public List<GetAllHrmsPersonResponse> getAll() {
        List<HrmsPerson> hrmsPersons = hrmsPersonDao.findAll();

        List<GetAllHrmsPersonResponse> hrmsPersonResponses = hrmsPersons.stream()
                .map(hrmsPerson -> this.modelMapperService.forResponse()
                        .map(hrmsPerson, GetAllHrmsPersonResponse.class))
                .collect(Collectors.toList());
        return hrmsPersonResponses;
    }

    @Override
    public Result verifyEmployer(AddEmployerVerifyRequest addEmployerVerifyRequest) {
        //iş kuralları yazılacak daha once onaylanmıs vs...
        TemporaryEmployer temporaryEmployer = temporaryEmployerDao.findByTemporaryEmployerId(addEmployerVerifyRequest.getTemporaryEmployerId());

        Employer employer = this.modelMapperService.forRequest().map(temporaryEmployer, Employer.class);
        employerDao.save(employer);
        User user = new User();
        user.setEmail(temporaryEmployer.getEmail());
        user.setPassword(temporaryEmployer.getPassword());
        userDao.save(user);

        employer.setUser(user);
        temporaryEmployer.setVerifyStatus(true);
        temporaryEmployerDao.save(temporaryEmployer);
        employerVerifyService.add(addEmployerVerifyRequest);


        return new SuccessResult("İş Veren Doğrulandı");
    }


}
