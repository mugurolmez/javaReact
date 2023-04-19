package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.dataAcces.abstracts.JobDescriptionsDao;
import kodlama.io.hrms.entities.JobDescriptions;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/jobdescriptions")
@AllArgsConstructor


public class JobDescritionsControllers {
	JobDescriptionsDao jobDescriptionsDao;
	
	@GetMapping("/getall")
	public List<JobDescriptions> getall() {
		
		return this.jobDescriptionsDao.findAll();
	}
	
	

}
