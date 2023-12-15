package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerVerifyService;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployerVerifiesResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employerVerifies")
@AllArgsConstructor
public class EmployerVerifyControllers {
    @Autowired
    private EmployerVerifyService employerVerifyService;





    @GetMapping("/getall")
    public List<GetAllEmployerVerifiesResponse> getAll() {

        return this.employerVerifyService.getAll();
    }
}
