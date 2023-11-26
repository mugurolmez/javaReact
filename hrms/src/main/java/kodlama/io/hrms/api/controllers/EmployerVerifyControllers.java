package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerVerifyService;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployerVerifiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employerVerifies")
public class EmployerVerifyControllers {
    private EmployerVerifyService employerVerifyService;

    @Autowired
    public EmployerVerifyControllers(EmployerVerifyService employerVerifyService) {
        this.employerVerifyService = employerVerifyService;
    }


    @GetMapping("/getall")
    public List<GetAllEmployerVerifiesResponse> getAll() {

        return this.employerVerifyService.getAll();
    }
}
