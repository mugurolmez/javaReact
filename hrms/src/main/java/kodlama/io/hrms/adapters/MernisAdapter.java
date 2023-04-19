package kodlama.io.hrms.adapters;


import kodlama.io.hrms.business.abstracts.UserCheckService;
import kodlama.io.hrms.entities.User;

public class MernisAdapter implements UserCheckService {

    @Override
    public boolean CheckIfRealPerson(User User) {
        return false;
    }
}
