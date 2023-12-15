package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.LinkedinAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkedinAddressDao extends JpaRepository<LinkedinAddress, Integer> {
    LinkedinAddress getByJobSeekerJobSeekerId(int jobSeekerId);
}
