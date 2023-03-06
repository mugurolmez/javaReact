package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.dataAcces.abstracts.jobDescriptionsDao;
import kodlama.io.hrms.entities.jobDescriptions;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/jobdescriptions")
@AllArgsConstructor


public class jobDescritionsControllers {
	jobDescriptionsDao jobDescriptionsDao;
	
	@GetMapping("/getall")
	public List<jobDescriptions> getall() {
		
		return this.jobDescriptionsDao.findAll();
	}
	
	

}
