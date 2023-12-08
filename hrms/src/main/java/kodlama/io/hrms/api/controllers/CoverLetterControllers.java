package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.business.dtos.requests.AddCoverLetterRequest;
import kodlama.io.hrms.business.dtos.requests.AddFrameworkRequest;
import kodlama.io.hrms.entities.CoverLetter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cover-letter")
@AllArgsConstructor
public class CoverLetterControllers {
    private CoverLetterService coverLetterService;
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddCoverLetterRequest addCoverLetterRequest) {

        return ResponseEntity.ok(this.coverLetterService.add(addCoverLetterRequest));
    }
}
