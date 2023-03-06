package kodlama.io.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.jobDescriptions;

public interface jobDescriptionsDao extends JpaRepository<jobDescriptions, Integer>  {

}
