package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.dtos.requests.DeactiveJobAdvertisementRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
public class EmployerControllers {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/getall")
    public List<GetAllEmployersResponse> getAll() {

        return this.employerService.getAll();
    }

    @PutMapping("/deactivateJobAdvertisement")
    Result deactivateJobAdvertisement(@RequestBody DeactiveJobAdvertisementRequest deactiveJobAdvertisementRequest) {
        return employerService.deactivateJobAdvertisement(deactiveJobAdvertisementRequest);
    }
}
