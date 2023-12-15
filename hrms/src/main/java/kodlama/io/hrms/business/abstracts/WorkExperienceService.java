package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddWorkExperienceRequest;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.cvEntities.WorkExperience;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkExperienceService {

    Result add(AddWorkExperienceRequest addWorkExperienceRequest);

    DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId);

    List<WorkExperience> GetAllCvWorkExperiences(int jobSeekerId);
}
