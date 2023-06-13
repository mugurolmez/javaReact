package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.entities.Job;
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
@RequestMapping("/api/jobs")


public class JobControllers {
    @Autowired
    private JobService jobService;

    public JobControllers(JobService jobDescriptionService) {
        this.jobService = jobDescriptionService;
    }


    @GetMapping("/getall")
    public List<Job> getall() {

        return this.jobService.getAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Job job) {
        //responseEntity<?> kayıt ısleminin durumuna gore succes yada error donecek onu işlemin sonucu belirleyecek
        //Aop bütün metodların onune global ex.handler yazarız tum operasyonlara try catch yazmak yerıne 1 tane yazarsın tum operasyonlar
        //bunun ıcınden gecer

        //bu sistemde su turde hata olursa bu metodu devreye sok

        return ResponseEntity.ok(this.jobService.add(job));
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
