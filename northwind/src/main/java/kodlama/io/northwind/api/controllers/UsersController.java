package kodlama.io.northwind.api.controllers;


import jakarta.validation.Valid;
import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
//responseEntity<?> kayıt ısleminin durumuna gore succes yada error donecek onu işlemin sonucu belirleyecek
    //Aop bütün metodların onune global ex.handler yazarız tum operasyonlara try catch yazmak yerıne 1 tane yazarsın tum operasyonlar
    //bunun ıcınden gecer

    //bu sistemde su turde hata olursa bu metodu devreye sok

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
        //Hashmap map implementasyonu
    }
}
