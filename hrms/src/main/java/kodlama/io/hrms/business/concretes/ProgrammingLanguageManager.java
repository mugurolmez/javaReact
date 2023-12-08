package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.business.dtos.requests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.ProgrammingLanguageDao;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Optional;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageDao programmingLanguageDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao, ModelMapperService modelMapperService, JobSeekerDao jobSeekerDao) {
        this.programmingLanguageDao = programmingLanguageDao;
        this.modelMapperService = modelMapperService;
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public Result add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(addProgrammingLanguageRequest, ProgrammingLanguage.class);
        Optional<JobSeeker> optionalJobSeeker = jobSeekerDao.findById(addProgrammingLanguageRequest.getJobSeekerId());
        if(optionalJobSeeker.isEmpty()){
            return new ErrorResult("İş arayan Bulunamadı");
        }
        JobSeeker jobSeeker=optionalJobSeeker.get();
        programmingLanguage.setJobSeeker(jobSeeker);
        this.programmingLanguageDao.save(programmingLanguage);

        return new SuccessResult("Programlama Dili Eklendi");
    }
}
