package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddJobAdvertisementRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllActiveJobAdverrisementsResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllJobDescriptionsResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobAdvertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobAdvertisementService {
    Result add(AddJobAdvertisementRequest addJobAdvertisementRequest);
    List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrue();
    List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrueOrderByApplicationDeadlineAsc();
    List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrueOrderByApplicationDeadlineDesc();
}
