package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {
    List<ProgrammingLanguage> findAllByJobSeekerJobSeekerId(int jobSeekerId);
}
