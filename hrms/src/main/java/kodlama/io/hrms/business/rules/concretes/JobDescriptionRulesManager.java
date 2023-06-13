package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.business.rules.abstracts.JobDescriptionRulesService;
import kodlama.io.hrms.dataAcces.abstracts.JobDescriptionDao;
import org.springframework.stereotype.Service;

@Service
public class JobDescriptionRulesManager implements JobDescriptionRulesService {
    private JobDescriptionDao jobDescriptionDao;

    public JobDescriptionRulesManager(JobDescriptionDao jobDescriptionDao) {
        this.jobDescriptionDao = jobDescriptionDao;
    }

    @Override
    public boolean existsByJobDescriptionName(String jobDescriptionName) {
        return jobDescriptionDao.existsByJobDescriptionName(jobDescriptionName);
    }
}
