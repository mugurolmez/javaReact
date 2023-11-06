package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService{

    Result add(AddSchoolRequest addSchoolRequest);
    List<GetAllSchoolResponse> getAll();
}
