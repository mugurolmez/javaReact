package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.GithubAddressService;
import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetGithubAddressResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.entities.cvEntities.GithubAddress;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/github-address")
@AllArgsConstructor
public class GithubAddressControllers {

    @Autowired
    private GithubAddressService githubAddressService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddGithubAddressRequest addGithubAddressRequest) {

        return ResponseEntity.ok(this.githubAddressService.add(addGithubAddressRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult<GetGithubAddressResponse> findByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return this.githubAddressService.findByJobSeekerJobSeekerId(jobSeekerId);
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
