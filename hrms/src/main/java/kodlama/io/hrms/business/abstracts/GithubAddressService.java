package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllGithubAddressResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.GithubAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GithubAddressService {
    Result add(AddGithubAddressRequest addGithubAddressRequest);

    List<GetAllGithubAddressResponse> getAll();

    DataResult<GithubAddress> findAllByJobSeekerJobSeekerId(int jobSeekerId);
}
