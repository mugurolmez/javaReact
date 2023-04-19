package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobDescriptions;
import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    Result add(User user);
    List<User> getAll();


}
