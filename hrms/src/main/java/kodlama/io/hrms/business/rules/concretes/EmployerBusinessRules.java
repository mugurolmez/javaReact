package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.dataAcces.abstracts.EmployerDao;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class EmployerBusinessRules {
    private UserDao userDao;
    @Autowired
    public EmployerBusinessRules(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkIfEmployerEmailExists(String email) {
        return this.userDao.existsByEmail(email);
    }

}


