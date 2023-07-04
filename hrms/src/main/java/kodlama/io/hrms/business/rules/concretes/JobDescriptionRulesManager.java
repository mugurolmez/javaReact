package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.business.rules.abstracts.JobDescriptionRulesService;
import kodlama.io.hrms.dataAcces.abstracts.JobDescriptionDao;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class JobDescriptionRulesManager implements JobDescriptionRulesService {
    private JobDescriptionDao jobDescriptionDao;

    @Autowired
    public JobDescriptionRulesManager(JobDescriptionDao jobDescriptionDao) {
        this.jobDescriptionDao = jobDescriptionDao;
    }

    @Override
    public boolean existsByJobDescriptionName(String jobDescriptionName) {
        return jobDescriptionDao.existsByJobDescriptionName(jobDescriptionName);
    }
}
