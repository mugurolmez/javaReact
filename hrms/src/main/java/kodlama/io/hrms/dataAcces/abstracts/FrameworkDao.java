package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrameworkDao extends JpaRepository<Framework, Integer> {

    List<Framework> findByProgrammingLanguage_ProgrammingLanguageId(int programmingLanguageId);

}
