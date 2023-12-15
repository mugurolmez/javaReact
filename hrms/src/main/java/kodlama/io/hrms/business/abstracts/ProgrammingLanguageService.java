package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.cvEntities.Language;
import kodlama.io.hrms.entities.cvEntities.ProgrammingLanguage;
import org.springframework.stereotype.Service;

@Service
public interface ProgrammingLanguageService {
    Result add(AddProgrammingLanguageRequest addProgrammingLanguageRequest);

    DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId);

}
