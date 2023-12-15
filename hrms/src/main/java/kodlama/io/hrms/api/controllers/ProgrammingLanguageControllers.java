package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.business.dtos.requests.AddProgrammingLanguageRequest;
import kodlama.io.hrms.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/programming-languages")
@AllArgsConstructor
public class ProgrammingLanguageControllers {
    @Autowired
    private ProgrammingLanguageService programmingLanguageService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddProgrammingLanguageRequest addProgrammingLanguageRequest) {

        return ResponseEntity.ok(this.programmingLanguageService.add(addProgrammingLanguageRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult findAllByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return this.programmingLanguageService.findAllByJobSeekerJobSeekerId(jobSeekerId);
    }
}
