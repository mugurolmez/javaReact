package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDao extends JpaRepository<Cv,Integer> {

}
