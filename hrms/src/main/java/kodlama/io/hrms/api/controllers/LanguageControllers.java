package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.dtos.requests.AddLanguageRequest;
import kodlama.io.hrms.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageControllers {

    private LanguageService languageService;
    private JobSeekerService jobSeekerService;

    @Autowired
    public LanguageControllers(LanguageService languageService, JobSeekerService jobSeekerService) {
        this.languageService = languageService;
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddLanguageRequest addLanguageRequest) {

        return ResponseEntity.ok(this.languageService.add(addLanguageRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult findAllByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return languageService.findAllByJobSeekerJobSeekerId(jobSeekerId);
    }
}