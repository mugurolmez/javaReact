package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllCvSchoolResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import lombok.AllArgsConstructor;
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
@RequestMapping("api/schools")
@AllArgsConstructor
public class SchoolControllers {
    @Autowired
    private SchoolService schoolService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddSchoolRequest addSchoolRequest) {

        return ResponseEntity.ok(this.schoolService.add(addSchoolRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult<List<GetAllCvSchoolResponse>> findAllByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return this.schoolService.findAllByJobSeeker_JobSeekerId(jobSeekerId);
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
