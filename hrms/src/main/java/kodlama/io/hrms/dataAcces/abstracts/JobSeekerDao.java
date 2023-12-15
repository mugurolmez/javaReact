package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.userEntities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
