package kodlama.io.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.JobDescriptions;

public interface JobDescriptionsDao extends JpaRepository<JobDescriptions, Integer>  {

}
