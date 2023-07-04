package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/employers")
public class EmployerControllers {

    private EmployerService employerService;
    @Autowired
    public EmployerControllers(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("/getall")
    public List<GetAllEmployersResponse> getAll(){

        return this.employerService.getAll();
    }
}
