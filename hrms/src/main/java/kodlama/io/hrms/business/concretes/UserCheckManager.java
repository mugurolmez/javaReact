package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserCheckManager implements UserCheckService {

    UserDao userDao;

    public UserCheckManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean CheckIfRealPerson(User user) {
        //mernis bağlayamadım ama tc 11 hane ise bağlanmısım gibi true donecek değilse false dönecek
     if(user.getNationalityId().length()==11) {

            return true;
        }else{

         return  false;
        }

}}
