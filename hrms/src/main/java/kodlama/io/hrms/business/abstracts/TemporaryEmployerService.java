package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddTemporaryEmployerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllTemporaryEmployersResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TemporaryEmployerService {
    Result add(AddTemporaryEmployerRequest addTemporaryEmployerRequest);

    List<GetAllTemporaryEmployersResponse> getAll();

    Result getById(int id);
}
