package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.FrameworkService;
import kodlama.io.hrms.business.dtos.requests.AddFrameworkRequest;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllCvLanguagesResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllProgrammingLanguageAndFrameworksResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/frameworks")
@AllArgsConstructor
public class FrameworksController {
    @Autowired
    private FrameworkService frameworkService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddFrameworkRequest addFrameworkRequest) {

        return ResponseEntity.ok(this.frameworkService.add(addFrameworkRequest));
    }
    @GetMapping("/{jobSeekerId}")
    DataResult<List<GetAllProgrammingLanguageAndFrameworksResponse>> findAllByLanguage_id(@PathVariable int jobSeekerId){

        return this.frameworkService.findAllByLanguage_id(jobSeekerId);

    }

}
