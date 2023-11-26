package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.TemporaryEmployerService;
import kodlama.io.hrms.business.dtos.requests.AddTemporaryEmployerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllTemporaryEmployersResponse;
import kodlama.io.hrms.business.dtos.responses.GetByIdTemporaryEmployerResponse;
import kodlama.io.hrms.business.rules.concretes.TemporaryEmployerBusinessRules;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.TemporaryEmployerDao;
import kodlama.io.hrms.entities.TemporaryEmployer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class TemporaryEmployerManager implements TemporaryEmployerService {
    private TemporaryEmployerDao temporaryEmployerDao;
    private ModelMapperService modelMapperService;
    private EmailService emailService;
    private TemporaryEmployerBusinessRules temporaryEmployerBusinessRules;

    @Autowired
    public TemporaryEmployerManager(TemporaryEmployerDao temporaryEmployerDao, TemporaryEmployerBusinessRules temporaryEmployerBusinessRules, ModelMapperService modelMapperService, EmailService emailService) {
        this.temporaryEmployerDao = temporaryEmployerDao;
        this.modelMapperService = modelMapperService;
        this.emailService = emailService;
        this.temporaryEmployerBusinessRules = temporaryEmployerBusinessRules;
    }

    @Override
    public Result add(AddTemporaryEmployerRequest addTemporaryEmployerRequest) {
        String emailDomain = addTemporaryEmployerRequest.getEmail().substring(addTemporaryEmployerRequest.getEmail().lastIndexOf("@") + 1);
        String websiteDomain = addTemporaryEmployerRequest.getWebSite().toLowerCase().replaceFirst("^(www\\.|http://)", "");
        if (!emailDomain.equalsIgnoreCase(websiteDomain)) {
            return new ErrorResult("Email adresi ve şirket web sitesi aynı domainde olmalı");
        }

        if (this.temporaryEmployerBusinessRules.checkIfTemporaryEmployerEmailExists(addTemporaryEmployerRequest.getEmail())) {
            return new ErrorResult("Bu E-posta adresı zaten kullanılıyor");
        }

        TemporaryEmployer temporaryEmployer = this.modelMapperService.forRequest().map(addTemporaryEmployerRequest, TemporaryEmployer.class);
        temporaryEmployer.setVerifyStatus(false);
        this.temporaryEmployerDao.save(temporaryEmployer);

        this.emailService.sendVerificationEmail(addTemporaryEmployerRequest.getEmail());
        return new SuccessResult(addTemporaryEmployerRequest.getEmail() + " Adresine Doğrulama Maili Gönderildi.");


    }

    @Override
    public List<GetAllTemporaryEmployersResponse> getAll() {
        List<TemporaryEmployer> temporaryEmployers = temporaryEmployerDao.findAll();

        List<GetAllTemporaryEmployersResponse> temporaryEmployersResponses = temporaryEmployers.stream()
                .map(employer -> this.modelMapperService.forResponse()
                        .map(employer, GetAllTemporaryEmployersResponse.class)).collect(Collectors.toList());
        return temporaryEmployersResponses;
    }

    @Override
    public Result getById(int temporaryEmployerId) {
        Optional<TemporaryEmployer> temporaryEmployerOptional = this.temporaryEmployerDao.findById(temporaryEmployerId);

        if (temporaryEmployerOptional.isEmpty()) {
            return new ErrorResult("Belirtilen ID'ye sahip iş veren bulunamadı.");
        }

        TemporaryEmployer temporaryEmployer = temporaryEmployerOptional.get();
        GetByIdTemporaryEmployerResponse response = this.modelMapperService.forResponse().map(temporaryEmployer, GetByIdTemporaryEmployerResponse.class);
        return new SuccessDataResult<>(response, "İş Tanımı Bulundu");

    }


}
