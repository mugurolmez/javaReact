package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class UserBusinessRules {
    private UserDao userDao;
@Autowired
    public UserBusinessRules(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkIfUserEmailExists(String email) {
        return this.userDao.existsByEmail(email);
    }

    }

