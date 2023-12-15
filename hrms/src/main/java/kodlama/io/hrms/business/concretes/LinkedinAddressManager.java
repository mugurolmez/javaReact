package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.LinkedinAddressService;
import kodlama.io.hrms.business.dtos.requests.AddGithubAddressRequest;
import kodlama.io.hrms.business.dtos.requests.AddLinkedinAddressRequest;
import kodlama.io.hrms.business.dtos.responses.GetGithubAddressResponse;
import kodlama.io.hrms.business.dtos.responses.GetLinkedinAddressResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.LinkedinAddressDao;
import kodlama.io.hrms.entities.cvEntities.GithubAddress;
import kodlama.io.hrms.entities.cvEntities.LinkedinAddress;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class LinkedinAddressManager implements LinkedinAddressService {
    @Autowired
    private JobSeekerDao jobSeekerDao;
    private ModelMapperService modelMapperService;
    private LinkedinAddressDao linkedinAddressDao;

    @Override
    public Result add(AddLinkedinAddressRequest addLinkedinAddressRequest) {
        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(addLinkedinAddressRequest.getJobSeekerId());

        if (optionalJobSeeker.isEmpty()) {
            return new ErrorResult("Jobseeker Bulunamadı");
        }

        LinkedinAddress linkedinAddress = this.modelMapperService.forRequest().map(addLinkedinAddressRequest, LinkedinAddress.class);

        this.linkedinAddressDao.save(linkedinAddress);

        return new SuccessResult("linkedin Adres Bilgisi Eklendi");
    }


    @Override
    public DataResult<GetLinkedinAddressResponse> findByJobSeekerJobSeekerId(int jobSeekerId) {
        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(jobSeekerId);

        if (optionalJobSeeker.isEmpty()) {
            return new ErrorDataResult<>("Jobseeker Bulunamadı");
        }
        LinkedinAddress linkedinAddress=this.linkedinAddressDao.getByJobSeekerJobSeekerId(jobSeekerId);
        GetLinkedinAddressResponse getLinkedinAddressResponse=this.modelMapperService
                .forResponse().map(linkedinAddress,GetLinkedinAddressResponse.class);


        return new SuccessDataResult<>(getLinkedinAddressResponse, "Github Adresi Listelendi");
    }
}
