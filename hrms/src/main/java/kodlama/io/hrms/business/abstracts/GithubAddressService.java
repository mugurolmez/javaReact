package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetGithubAddressResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.cvEntities.GithubAddress;
import org.springframework.stereotype.Service;

@Service
public interface GithubAddressService {
    Result add(AddGithubAddressRequest addGithubAddressRequest);

    DataResult<GetGithubAddressResponse> findByJobSeekerJobSeekerId(int jobSeekerId);

}
