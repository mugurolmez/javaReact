package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.dtos.requests.AddUserRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllUsersResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import kodlama.io.hrms.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UserManager implements UserService {
    private ModelMapperService modelMapperService;
    private UserDao userDao;
    private EmailService emailService;

    @Override
    public Result add(AddUserRequest addUserRequest) {
        User user = this.modelMapperService.forRequest().map(addUserRequest, User.class);

        this.userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userDao.findAll();

        List<GetAllUsersResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService
                        .forResponse()
                        .map(user, GetAllUsersResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }
}