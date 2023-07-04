package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddEmployerVerifyRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployerVerifiesResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployerVerifyService {

    Result add(AddEmployerVerifyRequest addEmployerVerifyRequest);
    List<GetAllEmployerVerifiesResponse> getAll();
}
