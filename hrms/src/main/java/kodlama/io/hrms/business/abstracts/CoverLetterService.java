package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddCoverLetterRequest;
import kodlama.io.hrms.business.dtos.responses.GetCoverLetterResponse;
import kodlama.io.hrms.business.dtos.responses.GetLinkedinAddressResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetCvCoverLetterResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.cvEntities.LinkedinAddress;
import org.springframework.stereotype.Service;

@Service
public interface CoverLetterService {
    Result add(AddCoverLetterRequest addCoverLetterRequest);

    DataResult<GetCoverLetterResponse> findByJobSeekerJobSeekerId(int jobSeekerId);
}
