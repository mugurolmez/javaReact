package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddLanguageRequest;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LanguageService {
    Result add(AddLanguageRequest addLanguageRequest);
    DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId);

}
