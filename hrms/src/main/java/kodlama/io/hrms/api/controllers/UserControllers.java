package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.JobDescriptions;
import kodlama.io.hrms.entities.User;
import kodlama.io.hrms.dataAcces.abstracts.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")


public class UserControllers {

    UserService userService;
    UserDao userDao;
    @Autowired
    public UserControllers(UserService userService,UserDao userDao) {
        this.userService = userService;
        this.userDao= userDao;
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){

        return  this.userService.add(user);
    }
    @GetMapping("/getall")
    public List<User> getall() {

        return this.userDao.findAll();
    }
}
