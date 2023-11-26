package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.dataAccess.UserDao;
import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userdao;
    @Autowired
    public UserManager(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public Result add(User user) {
        this.userdao.save(user);
        return new SuccessResult("Kullanıcı Eklendi") ;
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userdao.findByEmail(email),"Kullanıcı bulundu");
    }
}
