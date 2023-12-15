package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.business.dtos.requests.AddCoverLetterRequest;
import kodlama.io.hrms.business.dtos.responses.GetCoverLetterResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetCvCoverLetterResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.CoverLetterDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.cvEntities.CoverLetter;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CoverLetterManager implements CoverLetterService {
    @Autowired
    private CoverLetterDao coverLetterDao;
    private JobSeekerDao jobSeekerDao;
    private ModelMapperService modelMapperService;

    //iş kuralları eklenecek
    @Override
    public Result add(AddCoverLetterRequest addCoverLetterRequest) {
        Optional<JobSeeker> optionalJobSeeker = jobSeekerDao.findById(addCoverLetterRequest.getJobSeekerId());
        if (optionalJobSeeker.isEmpty()) {
            return new ErrorResult("İş arayan bulunamadı");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();

        CoverLetter coverLetter = this.modelMapperService.forRequest().map(addCoverLetterRequest, CoverLetter.class);
        coverLetter.setJobSeeker(jobSeeker);
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı Eklendi");
    }

    @Override
    public DataResult<GetCoverLetterResponse> findByJobSeekerJobSeekerId(int jobSeekerId) {
        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(jobSeekerId);

        if (optionalJobSeeker.isEmpty()) {
            return new ErrorDataResult<>("Jobseeker Bulunamadı");
        }
        CoverLetter coverLetter = this.coverLetterDao.getByJobSeekerJobSeekerId(jobSeekerId);
        GetCoverLetterResponse getCoverLetterResponse = this.modelMapperService
                .forResponse().map(coverLetter, GetCoverLetterResponse.class);


        return new SuccessDataResult<>(getCoverLetterResponse, "Github Adresi Listelendi");
    }
}
