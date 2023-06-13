package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {


}
