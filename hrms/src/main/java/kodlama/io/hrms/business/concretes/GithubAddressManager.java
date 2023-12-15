package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.GithubAddressService;
import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetGithubAddressResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.GithubAddressDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.cvEntities.GithubAddress;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GithubAddressManager implements GithubAddressService {
    @Autowired
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;
    private GithubAddressDao githubAddressDao;

    @Override
    public Result add(AddGithubAddressRequest addGithubAddressRequest) {

     Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(addGithubAddressRequest.getJobSeekerId());

       if (optionalJobSeeker.isEmpty()) {
           return new ErrorResult("Jobseeker Bulunamadı");
        }

        GithubAddress githubAddress = this.modelMapperService.forRequest().map(addGithubAddressRequest, GithubAddress.class);

        this.githubAddressDao.save(githubAddress);

        return new SuccessResult("github Adres Bilgisi Eklendi");
    }

    @Override
    public DataResult<GetGithubAddressResponse> findByJobSeekerJobSeekerId(int jobSeekerId) {
        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(jobSeekerId);

        if (optionalJobSeeker.isEmpty()) {
            return new ErrorDataResult<>("Jobseeker Bulunamadı");
        }
        GithubAddress githubAddress=this.githubAddressDao.getByJobSeekerJobSeekerId(jobSeekerId);
        GetGithubAddressResponse getGithubAddressResponse=this.modelMapperService
                .forResponse().map(githubAddress,GetGithubAddressResponse.class);


        return new SuccessDataResult<>(getGithubAddressResponse, "Github Adresi Listelendi");
    }


}
