package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.GithubAddressService;
import kodlama.io.hrms.business.abstracts.LinkedinAddressService;
import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.requests.AddLinkedinAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetGithubAddressResponse;
import kodlama.io.hrms.business.dtos.responses.GetLinkedinAddressResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api/linkedin-address")
public class LinkedinAddressControllers {

    @Autowired
    private LinkedinAddressService linkedinAddressService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddLinkedinAddressRequest addLinkedinAddressRequest) {

        return ResponseEntity.ok(this.linkedinAddressService.add(addLinkedinAddressRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult<GetLinkedinAddressResponse> findByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return this.linkedinAddressService.findByJobSeekerJobSeekerId(jobSeekerId);
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
