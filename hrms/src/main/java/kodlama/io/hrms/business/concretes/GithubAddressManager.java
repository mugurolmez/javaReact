package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.GithubAddressService;
import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllGithubAddressResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.GithubAddressDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.GithubAddress;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GithubAddressManager implements GithubAddressService {
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;
    private GithubAddressDao githubAddressDao;
    @Autowired
    public GithubAddressManager(ModelMapperService modelMapperService, JobSeekerDao jobSeekerDao, GithubAddressDao githubAddressDao) {
        this.modelMapperService = modelMapperService;
        this.jobSeekerDao = jobSeekerDao;
        this.githubAddressDao = githubAddressDao;
    }

    @Override
    public Result add(AddGithubAddressRequest addGithubAddressRequest) {

     Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(addGithubAddressRequest.getJobSeekerId());

       if (optionalJobSeeker.isEmpty()) {

           return new ErrorResult("Jobseeker Bulunamadı");
        }

        if (githubAddressDao.existsByJobSeeker_JobSeekerId(addGithubAddressRequest.getJobSeekerId())) {
            return new ErrorResult("Kayıtlı github adresi var");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();


        GithubAddress githubAddress = modelMapperService.forRequest().map(addGithubAddressRequest, GithubAddress.class);
        githubAddress.setJobSeeker(jobSeeker);

        this.githubAddressDao.save(githubAddress);

        return new SuccessResult("github Adres Bilgisi Eklendi");
    }

    @Override
    public List<GetAllGithubAddressResponse> getAll() {
        return null;
    }

    @Override
    public DataResult<GithubAddress> findAllByJobSeekerJobSeekerId(int jobSeekerId) {
        return null;
    }
}
