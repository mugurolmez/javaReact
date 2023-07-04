package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.HrmsPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrmsPersonDao extends   JpaRepository<HrmsPerson, Integer> {
}
