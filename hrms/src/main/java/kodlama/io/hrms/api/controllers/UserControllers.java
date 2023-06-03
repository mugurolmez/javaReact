package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.dtos.requests.AddUserRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllUsersResponse;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserControllers {

    private UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<GetAllUsersResponse> getall() {

        return userService.getAll();
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddUserRequest addUserRequest) {

        return ResponseEntity.ok(this.userService.add(addUserRequest));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
        return errors;
    }

}


