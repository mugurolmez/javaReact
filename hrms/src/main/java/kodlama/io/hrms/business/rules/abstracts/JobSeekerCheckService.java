package kodlama.io.hrms.business.rules.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobSeeker;

import org.springframework.stereotype.Service;

@Service
public interface JobSeekerCheckService {
    boolean CheckIfRealJobSeeker(AddJobSeekerRequest addJobSeekerRequest);

}
