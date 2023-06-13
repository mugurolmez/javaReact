package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobDescriptionService;
import kodlama.io.hrms.business.dtos.requests.AddJobDescriptionRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobDescriptionsResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllUsersResponse;
import kodlama.io.hrms.business.rules.abstracts.JobDescriptionRulesService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobDescriptionDao;
import kodlama.io.hrms.entities.JobDescription;
import kodlama.io.hrms.entities.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class JobDescriptionManager implements JobDescriptionService {


    private JobDescriptionDao jobDescriptionDao;
    private JobDescriptionRulesService jobDescriptionRulesService;
    private ModelMapperService modelMapperService;

    @Autowired
    public JobDescriptionManager(JobDescriptionRulesService jobDescriptionRulesService,JobDescriptionDao jobDescriptionDao,ModelMapperService modelMapperService) {
        this.jobDescriptionDao = jobDescriptionDao;
        this.modelMapperService=modelMapperService;
        this.jobDescriptionRulesService=jobDescriptionRulesService;
    }

    @Override
    public List<GetAllJobDescriptionsResponse> getAll() {
        List<JobDescription> jobDescriptions = this.jobDescriptionDao.findAll();

        List<GetAllJobDescriptionsResponse> jobDescriptionsResponses = jobDescriptions.stream()
                .map(jobDescription -> this.modelMapperService
                        .forResponse()
                        .map(jobDescription, GetAllJobDescriptionsResponse.class))
                .collect(Collectors.toList());
        return jobDescriptionsResponses;
    }

    @Override
    public Result add(AddJobDescriptionRequest addJobDescriptionRequest) {
        if(jobDescriptionRulesService.existsByJobDescriptionName(addJobDescriptionRequest.getJobDescriptionName())){
            return new ErrorResult("İş Tanımı Tekrarlanamaz");
        }

        JobDescription jobDescription = this.modelMapperService.forRequest().map(addJobDescriptionRequest, JobDescription.class);
        this.jobDescriptionDao.save(jobDescription);
        return new SuccessResult("İş Tanımı Eklendi");
    }
}