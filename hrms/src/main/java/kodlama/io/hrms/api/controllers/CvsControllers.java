package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetByJobSeekerIdCvResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Cvs")
@AllArgsConstructor
public class CvsControllers {
    @Autowired
    private CvService cvService;


    @GetMapping("/{jobSeekerId}")
    public DataResult<GetByJobSeekerIdCvResponse> getAll(int jobSeekerId) {
        return cvService.getAll(jobSeekerId);
    }

}
