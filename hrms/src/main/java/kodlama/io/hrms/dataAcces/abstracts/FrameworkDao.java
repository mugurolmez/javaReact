package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameworkDao extends JpaRepository<Framework,Integer> {
}
