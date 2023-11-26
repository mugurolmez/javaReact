package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.EmployerVerify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerVerifyDao extends JpaRepository<EmployerVerify,Integer> {
}
