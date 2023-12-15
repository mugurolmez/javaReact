package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {
    List<Language> findAllByJobSeekerJobSeekerId(int jobSeekerId);


}
