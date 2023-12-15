package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvDao extends JpaRepository<Cv, Integer> {

}
