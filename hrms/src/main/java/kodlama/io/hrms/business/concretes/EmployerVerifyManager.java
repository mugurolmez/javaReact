package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerVerifyService;
import kodlama.io.hrms.business.dtos.requests.AddEmployerVerifyRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployerVerifiesResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.EmployerVerifyDao;
import kodlama.io.hrms.entities.EmployerVerify;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployerVerifyManager implements EmployerVerifyService {
    @Autowired
    private EmployerVerifyDao employerVerifyDao;
    private ModelMapperService modelMapperService;


    @Override
    public Result add(AddEmployerVerifyRequest addEmployerVerifyRequest) {
        EmployerVerify employerVerify = this.modelMapperService.forResponse().map(addEmployerVerifyRequest, EmployerVerify.class);
        this.employerVerifyDao.save(employerVerify);


        return new SuccessResult("Doğrulama Başarılı");
    }

    @Override
    public List<GetAllEmployerVerifiesResponse> getAll() {
        List<EmployerVerify> employerVerifies = employerVerifyDao.findAll();

        List<GetAllEmployerVerifiesResponse> employerVerifiesResponses = employerVerifies.stream()
                .map(employerVerify -> this.modelMapperService.forResponse()
                        .map(employerVerify, GetAllEmployerVerifiesResponse.class)).collect(Collectors.toList());
        return employerVerifiesResponses;
    }
}
