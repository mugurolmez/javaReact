package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.dtos.requests.DeactiveJobAdvertisementRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/deactivateJobAdvetisement")
    Result deactivateJobAdvetisement(@RequestBody DeactiveJobAdvertisementRequest deactiveJobAdvertisementRequest) {
        return employerService.deactivateJobAdvetisement(deactiveJobAdvertisementRequest);
    }
}
