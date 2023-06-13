package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobDao extends JpaRepository<Job, Integer> {

}
