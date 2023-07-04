package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobDescriptionService;
import kodlama.io.hrms.business.dtos.requests.AddJobDescriptionRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobDescriptionsResponse;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
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
@RequestMapping("/api/jobDescriptions")


public class JobDescriptionControllers {
    @Autowired
    private JobDescriptionService jobDescriptionService;

    public JobDescriptionControllers(JobDescriptionService jobDescriptionService) {
        this.jobDescriptionService = jobDescriptionService;
    }

    @GetMapping("/getall")
    public List<GetAllJobDescriptionsResponse> getall() {

        return this.jobDescriptionService.getAll();
    }


    @GetMapping("/{id}")//{} değişkenden gelecek değer
    public Result getById(@PathVariable int id){
        return jobDescriptionService.getById(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddJobDescriptionRequest addJobDescriptionRequest) {


        return ResponseEntity.ok(this.jobDescriptionService.add(addJobDescriptionRequest));
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

////veri tabanına uniqu alan için handler jobname iki kere girilmeye çalışıldığında 500 hatası almamak için
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ErrorDataResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//		String errorMessage = "Bu İş Tanımı Daha Önce Eklenmiş Bu Alan Tekrarlanamaz";
//		ErrorDataResult<Object> error = new ErrorDataResult<>(errorMessage);
//		return error;
//	}


}
