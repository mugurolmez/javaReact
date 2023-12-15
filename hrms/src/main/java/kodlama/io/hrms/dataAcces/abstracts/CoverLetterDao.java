package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.cvEntities.CoverLetter;
import kodlama.io.hrms.entities.cvEntities.LinkedinAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
    CoverLetter getByJobSeekerJobSeekerId(int jobSeekerId);
}
