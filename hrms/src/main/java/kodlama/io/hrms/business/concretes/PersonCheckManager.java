package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.adapters.PersonCheckService;
import kodlama.io.hrms.business.abstracts.PersonService;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.stereotype.Service;


public class PersonCheckManager implements PersonCheckService{


    @Override
    public boolean CheckIfRealJobSeeker(JobSeeker jobseeker) {
        return true;
    }
}
