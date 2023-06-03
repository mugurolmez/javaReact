package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobDescriptionService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobDescriptionDao;
import kodlama.io.hrms.entities.JobDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobdescriptionManager implements JobDescriptionService {


    JobDescriptionDao jobDescriptionDao;

    @Autowired
    public JobdescriptionManager(JobDescriptionDao jobDescriptionDao) {
        this.jobDescriptionDao = jobDescriptionDao;
    }

    @Override
    public List<JobDescription> getAll() {
        return jobDescriptionDao.findAll();
    }

    @Override
    public Result add(JobDescription jobDescription) {

        this.jobDescriptionDao.save(jobDescription);
        return new SuccessResult("İş Tanımı Eklendi");
    }
}
