package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.HrmsPersonService;
import kodlama.io.hrms.business.dtos.requests.AddEmployerVerifyRequest;
import kodlama.io.hrms.business.dtos.requests.AddHrmsPersonRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllHrmsPersonResponse;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/hrmsPersons")
@EnableJpaRepositories
public class HrmsPersonControllers {
    @Autowired
    private HrmsPersonService hrmsPersonService;

    public HrmsPersonControllers(HrmsPersonService hrmsPersonService) {
        this.hrmsPersonService = hrmsPersonService;

    }

    @GetMapping("/get-all")
    public List<GetAllHrmsPersonResponse> getall() {

        return this.hrmsPersonService.getAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddHrmsPersonRequest addHrmsPersonRequest) {

        return ResponseEntity.ok(this.hrmsPersonService.add(addHrmsPersonRequest));
    }
    @PostMapping(value = "/verify-employer")
    public ResponseEntity<?> verifyEmployer(AddEmployerVerifyRequest addEmployerVerifyRequest) {
        return ResponseEntity.ok(this.hrmsPersonService.verifyEmployer(addEmployerVerifyRequest));

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
