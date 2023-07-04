package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.TemporaryEmployerService;
import kodlama.io.hrms.business.dtos.requests.AddTemporaryEmployerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllTemporaryEmployersResponse;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.TemporaryEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/temporaryEmployers")

public class TemporaryEmployerControllers {

    private TemporaryEmployerService temporaryEmployerService;
    @Autowired
    public TemporaryEmployerControllers(TemporaryEmployerService temporaryEmployerService) {
        this.temporaryEmployerService = temporaryEmployerService;
    }



    @GetMapping("/getall")
    public List<GetAllTemporaryEmployersResponse> getAll(){

        return this.temporaryEmployerService.getAll();
    }

    @GetMapping("/{id}")//{} değişkenden gelecek değer
    public Result getById(@PathVariable int id){
        return temporaryEmployerService.getById(id);
    }




    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddTemporaryEmployerRequest addTemporaryEmployerRequest) {

        return ResponseEntity.ok(this.temporaryEmployerService.add(addTemporaryEmployerRequest));
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
