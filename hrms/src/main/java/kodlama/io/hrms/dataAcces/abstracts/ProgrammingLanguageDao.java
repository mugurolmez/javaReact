package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {
}
