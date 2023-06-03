package kodlama.io.hrms.adapters;

import kodlama.io.hrms.entities.JobSeeker;

import org.springframework.stereotype.Service;

@Service
public interface PersonCheckService {
    boolean CheckIfRealJobSeeker(JobSeeker jobseeker);
}
