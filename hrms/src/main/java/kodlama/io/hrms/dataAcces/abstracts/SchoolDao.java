package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
