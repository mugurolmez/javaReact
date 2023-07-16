package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.dtos.requests.AddCityRequest;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.CityDao;
import kodlama.io.hrms.entities.City;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private ModelMapperService modelMapperService;
    private CityDao cityDao;


    @Override
    public Result add(AddCityRequest addCityRequest) {
        City city = modelMapperService.forRequest().map(addCityRequest, City.class);
        cityDao.save(city);
        return new SuccessResult("Şehir Eklendi");
    }
}
