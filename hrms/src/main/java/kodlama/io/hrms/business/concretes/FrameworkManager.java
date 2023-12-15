package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.FrameworkService;
import kodlama.io.hrms.business.dtos.requests.AddFrameworkRequest;
import kodlama.io.hrms.business.dtos.responses.cvitems.FrameworkResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllProgrammingLanguageAndFrameworksResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.FrameworkDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.ProgrammingLanguageDao;
import kodlama.io.hrms.entities.cvEntities.Framework;
import kodlama.io.hrms.entities.cvEntities.ProgrammingLanguage;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService {
    @Autowired
    private FrameworkDao frameworkDao;
    private ProgrammingLanguageDao programmingLanguageDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

    @Override
    public Result add(AddFrameworkRequest addFrameworkRequest) {
        Optional<ProgrammingLanguage> optionalProgrammingLanguage = programmingLanguageDao.findById(addFrameworkRequest.getProgrammingLanguageId());
        if (optionalProgrammingLanguage.isEmpty()) {
            return new ErrorResult("Programala Dili Bulunamadı");
        }
        ProgrammingLanguage programmingLanguage = optionalProgrammingLanguage.get();

        Framework framework = this.modelMapperService.forRequest().map(addFrameworkRequest, Framework.class);
        framework.setProgrammingLanguage(programmingLanguage);
        this.frameworkDao.save(framework);
        return new SuccessResult("FrameWork Eklendi");
    }

    public DataResult<List<GetAllProgrammingLanguageAndFrameworksResponse>> findAllByLanguage_id(int jobSeekerId) {
        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(jobSeekerId);
        if (optionalJobSeeker.isEmpty()) {
            return new ErrorDataResult<>("iş arayan bulunamadı");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();

        List<ProgrammingLanguage> languages = this.programmingLanguageDao.findAllByJobSeekerJobSeekerId(jobSeekerId);

        List<GetAllProgrammingLanguageAndFrameworksResponse> responses = languages.stream()
                .map(language -> {
                    List<Framework> frameworks = this.frameworkDao.findByProgrammingLanguage_ProgrammingLanguageId(language.getProgrammingLanguageId());

                    GetAllProgrammingLanguageAndFrameworksResponse response = new GetAllProgrammingLanguageAndFrameworksResponse();
                    response.setProgrammingLanguageName(language.getProgrammingLanguageName());

                    if (frameworks.isEmpty()) {
                        FrameworkResponse noFrameworkResponse = new FrameworkResponse();
                        noFrameworkResponse.setFrameworkName("frame work bilgisi yok");
                        response.setFrameWorks(Collections.singletonList(noFrameworkResponse));
                    } else {
                        List<FrameworkResponse> frameworkResponses = frameworks.stream()
                                .map(framework -> this.modelMapperService.forResponse()
                                        .map(framework, FrameworkResponse.class))
                                .collect(Collectors.toList());
                        response.setFrameWorks(frameworkResponses);
                    }

                    return response;
                })
                .collect(Collectors.toList());


        return new SuccessDataResult<>(responses, "Liste Yüklendi ");
    }
}
