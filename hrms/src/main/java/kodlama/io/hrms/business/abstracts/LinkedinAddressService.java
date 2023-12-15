package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddLinkedinAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetLinkedinAddressResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface LinkedinAddressService {

    Result add(AddLinkedinAddressRequest addLinkedinAddressRequest);

    DataResult<GetLinkedinAddressResponse> findByJobSeekerJobSeekerId(int jobSeekerId);
}
