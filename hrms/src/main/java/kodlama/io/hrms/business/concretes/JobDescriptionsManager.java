package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobDescriptionsService;
import kodlama.io.hrms.dataAcces.abstracts.JobDescriptionsDao;
import kodlama.io.hrms.entities.JobDescriptions;

@Service


public class JobDescriptionsManager implements JobDescriptionsService {
	
	JobDescriptionsDao jobDescriptionsDao;
	public JobDescriptionsManager(JobDescriptionsDao jobDescriptionsDao){
		super();
		this.jobDescriptionsDao = jobDescriptionsDao;

	}
	
	@Override
	public List<JobDescriptions> getAll() {

		return jobDescriptionsDao.findAll();
	}

}
