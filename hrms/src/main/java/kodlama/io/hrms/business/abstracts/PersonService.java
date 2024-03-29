package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.userEntities.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    Result add(Person person);

    List<Person> getAll();

}
