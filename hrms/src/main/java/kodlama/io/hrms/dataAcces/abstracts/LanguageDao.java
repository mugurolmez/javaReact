package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.Language;
import kodlama.io.hrms.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface LanguageDao extends JpaRepository<Language,Integer>{
    List<Language> findAllByJobSeekerJobSeekerId(int jobSeekerId);

}
