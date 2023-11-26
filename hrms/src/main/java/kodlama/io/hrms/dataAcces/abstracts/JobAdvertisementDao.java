package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> findAllByIsActiveTrue();
    List<JobAdvertisement> findAll();
    List<JobAdvertisement> findAllByIsActiveTrueOrderByApplicationDeadlineAsc();
    List<JobAdvertisement> findAllByOrderByApplicationDeadlineDesc();


}
