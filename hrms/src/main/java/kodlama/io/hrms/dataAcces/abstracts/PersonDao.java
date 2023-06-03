package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Integer> {

}
