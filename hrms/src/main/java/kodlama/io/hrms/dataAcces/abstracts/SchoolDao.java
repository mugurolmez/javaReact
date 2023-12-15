package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {

    List<School> findAllByJobSeeker_JobSeekerId(int jobSeekerId);

}
