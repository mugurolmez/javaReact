package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.School;
import kodlama.io.hrms.entities.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {

    List<WorkExperience> findAllByJobSeekerJobSeekerId(int jobSeekerId);
}
