package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddEmployerVerifyRequest;
import kodlama.io.hrms.business.dtos.requests.AddHrmsPersonRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllHrmsPersonResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HrmsPersonService {
    Result add(AddHrmsPersonRequest addHrmsPersonRequest);

    List<GetAllHrmsPersonResponse> getAll();

    Result verifyEmployer(AddEmployerVerifyRequest addEmployerVerifyRequest);
}
