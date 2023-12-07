package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.GithubAddress;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubAddressDao extends JpaRepository<GithubAddress,Integer> {
    boolean existsByJobSeeker_JobSeekerId(int jobSeekerId);
}
