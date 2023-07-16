package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> findAllByIsActiveTrue();
    List<JobAdvertisement> findAll();
    List<JobAdvertisement> findAllByIsActiveTrueOrderByApplicationDeadlineAsc();
    List<JobAdvertisement> findAllByOrderByApplicationDeadlineDesc();


}
