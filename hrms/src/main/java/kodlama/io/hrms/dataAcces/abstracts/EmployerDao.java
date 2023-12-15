package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.userEntities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
