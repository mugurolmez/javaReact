package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.userEntities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

    boolean existsByNationalityNumber(String nationalityNumber);

}
