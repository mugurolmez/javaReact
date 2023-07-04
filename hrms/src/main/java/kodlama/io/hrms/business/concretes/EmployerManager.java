package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.dtos.requests.AddEmployerRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllEmployersResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.dataAcces.abstracts.EmployerDao;
import kodlama.io.hrms.entities.Employer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private ModelMapperService modelMapperService;


    @Override
    public Result add(AddEmployerRequest addEmployerRequest) {
        return null;
    }

    @Override
    public List<GetAllEmployersResponse> getAll() {
        List<Employer> employers =employerDao.findAll();

        List<GetAllEmployersResponse> employersResponses=employers.stream()
                .map(employer->this.modelMapperService.forResponse()
                        .map(employer, GetAllEmployersResponse.class)).collect(Collectors.toList());
        return employersResponses;
    }
    }

