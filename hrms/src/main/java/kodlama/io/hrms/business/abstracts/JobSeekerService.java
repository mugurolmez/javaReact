package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobSeekerService {
    Result add(JobSeeker jobSeeker);
    List<JobSeeker> getAll();
}
