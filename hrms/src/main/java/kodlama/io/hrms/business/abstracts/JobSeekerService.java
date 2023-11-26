package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobSeekersResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobSeekerService {
    Result add(AddJobSeekerRequest addJobSeekerRequest);

    List<GetAllJobSeekersResponse> getAll();

}
