package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.dtos.requests.AddUserRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllUsersResponse;
import kodlama.io.hrms.business.rules.concretes.UserBusinessRules;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import kodlama.io.hrms.entities.userEntities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UserManager implements UserService {
    @Autowired
    private ModelMapperService modelMapperService;
    private UserDao userDao;
    private UserBusinessRules userBussinessRules;

    @Override
    public Result add(AddUserRequest addUserRequest) {
        if (this.userBussinessRules.checkIfUserEmailExists(addUserRequest.getEmail())) {
            return new ErrorResult("Bu E-posta adresı zaten kullanılıyor");
        }


        User user = this.modelMapperService.forRequest().map(addUserRequest, User.class);

        this.userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = this.userDao.findAll();

        List<GetAllUsersResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService
                        .forResponse()
                        .map(user, GetAllUsersResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }

}