package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.jobDescriptions;

@Service
public interface jobDescriptionsService {
	List<jobDescriptions> getAll();
}
