package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.business.dtos.requests.AddCoverLetterRequest;
import kodlama.io.hrms.business.dtos.responses.GetCoverLetterResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetCvCoverLetterResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cover-letter")
@AllArgsConstructor
public class CoverLetterControllers {
    @Autowired
    private CoverLetterService coverLetterService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddCoverLetterRequest addCoverLetterRequest) {

        return ResponseEntity.ok(this.coverLetterService.add(addCoverLetterRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult<GetCoverLetterResponse> findByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return this.coverLetterService.findByJobSeekerJobSeekerId(jobSeekerId);
    }
}
