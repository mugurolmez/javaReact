package kodlama.io.hrms.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.business.dtos.requests.AddProgrammingLanguageRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/programming-languages")
@AllArgsConstructor
public class ProgrammingLanguageControllers {
    private ProgrammingLanguageService programmingLanguageService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddProgrammingLanguageRequest addProgrammingLanguageRequest) {

        return ResponseEntity.ok(this.programmingLanguageService.add(addProgrammingLanguageRequest));
    }
}
