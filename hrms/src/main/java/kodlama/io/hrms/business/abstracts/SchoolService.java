package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllCvSchoolResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.cvEntities.School;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {

    Result add(AddSchoolRequest addSchoolRequest);

    DataResult<List<GetAllCvSchoolResponse>> findAllByJobSeeker_JobSeekerId(int jobSeekerId);
    List<GetAllCvSchoolResponse> getAllCvSchoolResponses(int jobsSeekerId);
}
