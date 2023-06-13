package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddEmployerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployerService {
    Result add(AddEmployerRequest addEmployerRequest);
    List<GetAllEmployersResponse> getAll();
}
