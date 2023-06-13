package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobDao;
import kodlama.io.hrms.entities.Job;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class JobManager implements JobService {


    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDescriptionDao) {
        this.jobDao = jobDao;
    }

    @Override
    public List<Job> getAll() {
        return this.jobDao.findAll();
    }

    @Override
    public Result add(Job job) {

        this.jobDao.save(job);
        return new SuccessResult("İş Tanımı Eklendi");
    }
}
