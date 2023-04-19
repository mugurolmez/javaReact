package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.User;

public interface UserCheckService {
    public boolean CheckIfRealPerson(User User);
}
