package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.dtos.requests.AddEmployerRequest;
import kodlama.io.hrms.business.dtos.requests.DeactiveJobAdvertisementRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.EmployerDao;
import kodlama.io.hrms.dataAcces.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.userEntities.Employer;
import kodlama.io.hrms.entities.JobAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {
    @Autowired
    private EmployerDao employerDao;
    private ModelMapperService modelMapperService;
    private JobAdvertisementDao jobAdvertisementDao;


    @Override
    public Result add(AddEmployerRequest addEmployerRequest) {
        return null;
    }

    @Override
    public List<GetAllEmployersResponse> getAll() {
        List<Employer> employers = employerDao.findAll();

        List<GetAllEmployersResponse> employersResponses = employers.stream()
                .map(employer -> this.modelMapperService.forResponse()
                        .map(employer, GetAllEmployersResponse.class)).collect(Collectors.toList());
        return employersResponses;
    }

    @Override
    public Result deactivateJobAdvertisement(@RequestBody() DeactiveJobAdvertisementRequest deactiveJobAdvertisementRequest) {
        Optional<Employer> employerOptional = employerDao.findById(deactiveJobAdvertisementRequest.getEmployerId());
        Optional<JobAdvertisement> jobAdvertisementOptional = jobAdvertisementDao.findById(deactiveJobAdvertisementRequest.getJobAdvertisementId());
        //opsiyonel verileri kontrol etmek ıcın değişkene atadım

        if (employerOptional.isEmpty()) {
            return new ErrorResult("İşveren Bulunamadı");
        }//employer var mı yok mu kontrol ettım
        if (jobAdvertisementOptional.isEmpty()) {
            return new ErrorResult("İş ilanı Bulunamadı");
        }
        if (!jobAdvertisementOptional.get().isActive()) {
            return new ErrorResult("İlan Zaten Pasif");
        }
        //geçici verileri gerçek verilere atatım
        Employer employer = employerOptional.get();
        JobAdvertisement jobAdvertisement = jobAdvertisementOptional.get();

        if (employer.getEmployerId() != jobAdvertisement.getEmployer().getEmployerId()) {
            return new ErrorResult("İş ilanı İş Verene Ait Değil İşlem Yapılamaz");
        }


        jobAdvertisement.setActive(false);
        jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult("İlan Pasif Hale Getirildi");

    }
}

