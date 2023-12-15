package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.TemporaryEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryEmployerDao extends JpaRepository<TemporaryEmployer, Integer> {

    TemporaryEmployer findByTemporaryEmployerId(int temporaryEmployerId);

}
