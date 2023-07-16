package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.business.dtos.requests.AddCityRequest;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface CityService {
    Result add(AddCityRequest addCityRequest);
}
