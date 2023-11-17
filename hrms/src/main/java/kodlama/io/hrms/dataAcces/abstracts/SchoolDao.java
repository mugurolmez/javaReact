package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface SchoolDao extends JpaRepository<School,Integer> {
    List<School> findAllByOrderByYearOfGraduationDesc();
    List<School> findAllByJobSeekerId(int jobSeekerId);
}
