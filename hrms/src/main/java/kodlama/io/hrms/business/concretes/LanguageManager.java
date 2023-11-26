package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.dtos.requests.AddLanguageRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllLanguagesResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.LanguageDao;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.Language;
import kodlama.io.hrms.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao, ModelMapperService modelMapperService, JobSeekerDao jobSeekerDao) {
        this.languageDao = languageDao;
        this.modelMapperService = modelMapperService;
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public Result add(AddLanguageRequest addLanguageRequest) {

        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(addLanguageRequest.getJobSeekerId());
        if(optionalJobSeeker.isEmpty()){
            return new ErrorResult("iş arayan Bulunamadı");
        }

        JobSeeker jobSeeker=optionalJobSeeker.get();

        Language language = modelMapperService.forRequest().map(addLanguageRequest, Language.class);
        language.setLanguageId(0);
        language.setJobSeeker(jobSeeker);

        this.languageDao.save(language);

        return new SuccessResult("Dil Bilgisi Eklendi");
    }

    @Override
    public DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId) {


        List<Language> languages = languageDao.findAllByJobSeekerJobSeekerId(jobSeekerId);

        //Dönüştürme
        List<GetAllLanguagesResponse> languagesResponses = languages.stream()
                .map(language -> this.modelMapperService.forResponse()
                        .map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());


        return new SuccessDataResult(languagesResponses,"Dil Bilgileri Listelendi");

    }

}
