package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.dataAcces.abstracts.PersonDao;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class HrmsPersonBusinessRules {
    private UserDao userDao;
    private PersonDao personDao;
    @Autowired
    public HrmsPersonBusinessRules(UserDao userDao,PersonDao personDao) {
        this.userDao = userDao;
        this.personDao=personDao;
    }

    public boolean checkIfHrmsPersonEmailExists(String email) {
        return this.userDao.existsByEmail(email);
    }
    public boolean checkIfHrmsPersonNationalityNumber(String nationalityNumber) {
        return this.personDao.existsByNationalityNumber(nationalityNumber);
    }
}
