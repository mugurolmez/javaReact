package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobSeekersResponse;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import lombok.AllArgsConstructor;
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
@RequestMapping("api/jobSeekers")
@AllArgsConstructor

public class JobSeekerControllers {
    @Autowired
    private JobSeekerService jobSeekerService;

    @GetMapping("/getall")
    public List<GetAllJobSeekersResponse> getall() {

        return this.jobSeekerService.getAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddJobSeekerRequest addJobSeekerRequest) {

        return ResponseEntity.ok(this.jobSeekerService.add(addJobSeekerRequest));
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

    //veri tabanına uniqu alan için handler jobname iki kere girilmeye çalışıldığında 500 hatası almamak için

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorDataResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
//        Map<String,String> validationErrors = new HashMap<String,String>();
//        for(FieldError fieldError: ex.getBindingResult().getFieldErrors()){
//            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
//        }
//        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"aynı veri tekra girilemez");
//        return errors;
//    }
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorDataResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//        String errorMessage = "Bu İş Tanımı Daha Önce Eklenmiş Bu Alan Tekrarlanamaz";
//        ErrorDataResult<Object> error = new ErrorDataResult<>(errorMessage);
//        return error;
//    }
}
