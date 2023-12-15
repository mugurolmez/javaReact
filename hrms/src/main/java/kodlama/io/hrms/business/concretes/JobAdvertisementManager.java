package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.dtos.requests.AddJobAdvertisementRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllActiveJobAdverrisementsResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.JobAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {
    @Autowired
    private ModelMapperService modelMapperService;
    private JobAdvertisementDao jobAdvertisementDao;

    @Override
    public Result add(AddJobAdvertisementRequest addJobAdvertisementRequest) {
        JobAdvertisement jobAdvertisement = modelMapperService.forRequest().map(addJobAdvertisementRequest, JobAdvertisement.class);
        jobAdvertisement.setActive(true);
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş Özellikleri eklendi");
    }

    @Override
    public List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrue() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByIsActiveTrue();

        List<GetAllActiveJobAdverrisementsResponse> getAllActiveJobAdverrisementsResponses = jobAdvertisements.stream()
                .map(jobAdvertisement -> {
                    GetAllActiveJobAdverrisementsResponse response = modelMapperService.forResponse().map(jobAdvertisement, GetAllActiveJobAdverrisementsResponse.class);
                    response.setEmployerName(jobAdvertisement.getEmployer().getCorporateName());
                    response.setJobDescriptionName(jobAdvertisement.getJobDescription().getJobDescriptionName());
                    return response;
                })
                .collect(Collectors.toList());

        return getAllActiveJobAdverrisementsResponses;


    }

    @Override
    public List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrueOrderByApplicationDeadlineAsc() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByIsActiveTrueOrderByApplicationDeadlineAsc();

        List<GetAllActiveJobAdverrisementsResponse> getAllActiveJobAdverrisementsResponses = jobAdvertisements.stream()
                .map(jobAdvertisement -> {
                    GetAllActiveJobAdverrisementsResponse response = modelMapperService.forResponse().map(jobAdvertisement, GetAllActiveJobAdverrisementsResponse.class);
                    response.setEmployerName(jobAdvertisement.getEmployer().getCorporateName());
                    response.setJobDescriptionName(jobAdvertisement.getJobDescription().getJobDescriptionName());
                    return response;
                })
                .collect(Collectors.toList());
        return getAllActiveJobAdverrisementsResponses;
    }

    @Override
    public List<GetAllActiveJobAdverrisementsResponse> findAllByIsActiveTrueOrderByApplicationDeadlineDesc() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByOrderByApplicationDeadlineDesc();

        List<GetAllActiveJobAdverrisementsResponse> getAllActiveJobAdverrisementsResponses = jobAdvertisements.stream()
                .map(jobAdvertisement -> {
                    GetAllActiveJobAdverrisementsResponse response = modelMapperService.forResponse().map(jobAdvertisement, GetAllActiveJobAdverrisementsResponse.class);
                    response.setEmployerName(jobAdvertisement.getEmployer().getCorporateName());
                    response.setJobDescriptionName(jobAdvertisement.getJobDescription().getJobDescriptionName());
                    return response;
                })
                .collect(Collectors.toList());
        return getAllActiveJobAdverrisementsResponses;
    }
}



