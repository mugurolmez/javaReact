package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.dtos.requests.AddJobAdvertisementRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllActiveJobAdverrisementsResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/JobAdvertisements")
@AllArgsConstructor
public class JobAdvertisementControllers {

    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddJobAdvertisementRequest addJobAdvertisementRequest) {


        return ResponseEntity.ok(this.jobAdvertisementService.add(addJobAdvertisementRequest));
    }

    @GetMapping("/getAllActiveTrue")
    public List<GetAllActiveJobAdverrisementsResponse> findByIsActiveTrue() {
        return jobAdvertisementService.findAllByIsActiveTrue();
    }

    @GetMapping("/getAllActiveTrueASC")
    public List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrueOrderByApplicationDeadlineAsc() {
        return jobAdvertisementService.findAllByIsActiveTrueOrderByApplicationDeadlineAsc();
    }

    @GetMapping("/getAllActiveTrueDESC")
    public List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrueOrderByApplicationDeadlineDesc() {
        return jobAdvertisementService.findAllByIsActiveTrueOrderByApplicationDeadlineDesc();
    }

}
