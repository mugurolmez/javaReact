package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddFrameworkRequest;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllCvLanguagesResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllProgrammingLanguageAndFrameworksResponse;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrameworkService {

    Result add(AddFrameworkRequest frameworkRequest);

    DataResult<List<GetAllProgrammingLanguageAndFrameworksResponse>> findAllByLanguage_id(int jobSeekerId);

}
