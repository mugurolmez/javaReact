package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddCoverLetterRequest;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface CoverLetterService {
    Result add(AddCoverLetterRequest addCoverLetterRequest);
}
