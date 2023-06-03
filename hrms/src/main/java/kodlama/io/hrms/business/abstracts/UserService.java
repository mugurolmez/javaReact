package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddUserRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllUsersResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Result add(AddUserRequest addUserRequest);

    List<GetAllUsersResponse> getAll();


}
