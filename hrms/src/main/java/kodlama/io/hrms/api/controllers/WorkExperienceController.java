package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.business.dtos.requests.AddWorkExperienceRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllWorkExperiencesResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/workExperinces")
@AllArgsConstructor
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddWorkExperienceRequest addWorkExperienceRequest) {

        return ResponseEntity.ok(this.workExperienceService.add(addWorkExperienceRequest));
    }

    @GetMapping("/{jobSeekerId}")//{} değişkenden gelecek değer
    public DataResult findAllByJobSeekerJobSeekerId(@PathVariable int jobSeekerId) {
        return workExperienceService.findAllByJobSeekerJobSeekerId(jobSeekerId);
    }
}