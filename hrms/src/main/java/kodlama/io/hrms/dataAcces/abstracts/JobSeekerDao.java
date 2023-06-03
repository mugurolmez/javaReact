package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
}
