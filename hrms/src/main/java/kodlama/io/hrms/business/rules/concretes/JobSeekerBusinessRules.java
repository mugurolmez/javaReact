package kodlama.io.hrms.business.rules.concretes;

import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.dataAcces.abstracts.PersonDao;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class JobSeekerBusinessRules {
    private UserDao userDao;
    private PersonDao personDao;
    @Autowired
    public JobSeekerBusinessRules(UserDao userDao,PersonDao personDao) {
        this.userDao = userDao;
        this.personDao=personDao;
    }

    public boolean checkIfJobseekerEmailExists(String email) {
        return this.userDao.existsByEmail(email);
    }
    public boolean checkIfJobSeekerNationalityNumber(String nationalityNumber) {
        return this.personDao.existsByNationalityNumber(nationalityNumber);
    }

}
