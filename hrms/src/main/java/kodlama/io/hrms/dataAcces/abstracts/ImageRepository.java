package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.Image;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    List<Image> findByOrderById();
    boolean existsByJobSeeker_JobSeekerId(int jobSeekerId);
}