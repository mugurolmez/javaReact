package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobDescriptionDao extends JpaRepository<JobDescription, Integer> {
    boolean existsByJobDescriptionName(String jobDescriptionName);
}
