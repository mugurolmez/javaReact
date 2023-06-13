package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.business.rules.abstracts.JobSeekerCheckService;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {

    @Override
    public boolean CheckIfRealJobSeeker(AddJobSeekerRequest addJobSeekerRequest) {
        return true;
    }

}



