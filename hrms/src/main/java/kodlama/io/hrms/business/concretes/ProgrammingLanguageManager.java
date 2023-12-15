package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.business.dtos.requests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobSeekersResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllLanguagesResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.FrameworkDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.ProgrammingLanguageDao;
import kodlama.io.hrms.entities.cvEntities.Framework;
import kodlama.io.hrms.entities.cvEntities.Language;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import kodlama.io.hrms.entities.cvEntities.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    @Autowired
    private ProgrammingLanguageDao programmingLanguageDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

    @Override
    public Result add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(addProgrammingLanguageRequest, ProgrammingLanguage.class);
        Optional<JobSeeker> optionalJobSeeker = jobSeekerDao.findById(addProgrammingLanguageRequest.getJobSeekerId());
        if (optionalJobSeeker.isEmpty()) {
            return new ErrorResult("İş arayan Bulunamadı");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();
        programmingLanguage.setProgrammingLanguageId(0);
        programmingLanguage.setJobSeeker(jobSeeker);
        this.programmingLanguageDao.save(programmingLanguage);

        return new SuccessResult("Programlama Dili Eklendi");
    }

    @Override
    public DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId) {

        List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageDao.findAllByJobSeekerJobSeekerId(jobSeekerId);

        //Dönüştürme
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = programmingLanguages.stream()
                .map(programmingLanguage -> this.modelMapperService.forResponse()
                        .map(programmingLanguage, GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());


        return new SuccessDataResult(programmingLanguagesResponses, "Programlama Dilleri Listelendi");
    }
}
