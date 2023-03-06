package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.jobDescriptionsService;
import kodlama.io.hrms.dataAcces.abstracts.jobDescriptionsDao;
import kodlama.io.hrms.entities.jobDescriptions;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class jobDescriptionsManager implements jobDescriptionsService {
	
	jobDescriptionsDao jobDescriptionsDao;
	
	
	@Override
	public List<jobDescriptions> getAll() {
		return jobDescriptionsDao.findAll();
	}

}
