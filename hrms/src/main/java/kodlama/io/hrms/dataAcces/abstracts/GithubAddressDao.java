package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.cvEntities.GithubAddress;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubAddressDao extends JpaRepository<GithubAddress, Integer> {
    GithubAddress getByJobSeekerJobSeekerId(int jobSeekerId);
}
