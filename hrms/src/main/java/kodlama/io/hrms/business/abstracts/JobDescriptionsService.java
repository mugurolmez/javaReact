package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.JobDescriptions;

@Service
public interface JobDescriptionsService {
	 List<JobDescriptions> getAll();
}
