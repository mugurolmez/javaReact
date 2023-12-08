package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.FrameworkService;
import kodlama.io.hrms.business.dtos.requests.AddFrameworkRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/frameworks")
@AllArgsConstructor
public class FrameworksController {
    private FrameworkService frameworkService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddFrameworkRequest addFrameworkRequest) {

        return ResponseEntity.ok(this.frameworkService.add(addFrameworkRequest));
    }

}
