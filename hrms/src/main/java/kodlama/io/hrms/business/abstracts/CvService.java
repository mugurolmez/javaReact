package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddCvRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllCvsResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CvService {
    List<GetAllCvsResponse> getAll();

    Result Add(AddCvRequest addCvRequest);
}
