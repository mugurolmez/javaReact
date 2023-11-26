package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddJobDescriptionRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobDescriptionsResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobDescriptionService {
    List<GetAllJobDescriptionsResponse> getAll();

    Result add(AddJobDescriptionRequest addJobDescriptionRequest);

    Result getById(int id);
}
