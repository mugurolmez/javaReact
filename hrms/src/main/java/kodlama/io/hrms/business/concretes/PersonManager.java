package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.PersonService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.PersonDao;
import kodlama.io.hrms.entities.userEntities.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonManager implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public Result add(Person person) {
        personDao.save(person);
        return new SuccessResult("Kişi Eklendi");
    }

    @Override
    public List<Person> getAll() {
        return this.personDao.findAll();
    }
}
