package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobDescriptionService {
    List<JobDescription> getAll();

    public Result add(JobDescription jobDescription);
}
