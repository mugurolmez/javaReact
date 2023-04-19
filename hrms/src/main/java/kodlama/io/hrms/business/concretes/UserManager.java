package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.business.abstracts.UserService;

import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import kodlama.io.hrms.entities.JobDescriptions;
import kodlama.io.hrms.entities.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class UserManager implements UserService {

    UserDao userDao;
    UserCheckService userCheckService;
    EmailService emailService;

    @Autowired
    public UserManager(UserDao userDao, UserCheckService userCheckService, EmailService emailService) {
        this.userDao = userDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public Result add(User user) {

        if (user.getName() == null ||
                user.getName().isEmpty()||//boş olursa yada yazılmazsa boşmu
                user.getLastName().isEmpty() ||
                user.getEmail().isEmpty() ||
                user.getPassword().isEmpty()
                    ) {
            return new ErrorResult("tüm Alanların Doldurulması Zorunludur");
        }

        if (userCheckService.CheckIfRealPerson(user)) {

            this.userDao.save(user);
            this.emailService.UserVerificationEmailService(user);
            return new SuccessResult("Kayıt Başarılı");
        }
        return new ErrorResult("Mernis Doğrulaması Başarısız");
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }
}

