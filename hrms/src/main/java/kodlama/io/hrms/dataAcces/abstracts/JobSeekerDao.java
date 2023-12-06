package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    Optional<JobSeeker> findById(int id);
}
