package kodlama.io.hrms.business.abstracts;


import kodlama.io.hrms.business.dtos.responses.cvitems.GetByJobSeekerIdCvResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import org.springframework.stereotype.Service;

@Service
public interface CvService {

    DataResult<GetByJobSeekerIdCvResponse> getAll(int jobSeekerId);

}
