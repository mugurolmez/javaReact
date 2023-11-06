package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.dtos.requests.AddCityRequest;
import kodlama.io.hrms.business.dtos.requests.AddCvRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllCvsResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.CvDao;
import kodlama.io.hrms.entities.City;
import kodlama.io.hrms.entities.Cv;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class CvManager implements CvService {
    private CvDao cvDao;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllCvsResponse> getAll() {
        List<Cv> cvs = cvDao.findAll();

        List<GetAllCvsResponse> getAllCvsResponses = cvs.stream()
                .map(cv -> this.modelMapperService.forResponse()
                        .map(cv, GetAllCvsResponse.class))
                .collect(Collectors.toList());
        return getAllCvsResponses;

    }

    @Override
    public Result Add(AddCvRequest addCvRequest) {

            Cv cv = modelMapperService.forRequest().map(addCvRequest, Cv.class);
            cvDao.save(cv);
            return new SuccessResult("Cv Eklendi");

    }
}
