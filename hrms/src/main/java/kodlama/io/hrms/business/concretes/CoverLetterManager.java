package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.business.dtos.requests.AddCoverLetterRequest;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.CoverLetterDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.CoverLetter;
import kodlama.io.hrms.entities.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoverLetterManager implements CoverLetterService {
    private CoverLetterDao coverLetterDao;
    private JobSeekerDao jobSeekerDao;
    private ModelMapperService modelMapperService;
    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao, JobSeekerDao jobSeekerDao, ModelMapperService modelMapperService) {
        this.coverLetterDao = coverLetterDao;
        this.jobSeekerDao = jobSeekerDao;
        this.modelMapperService = modelMapperService;
    }




    @Override
    public Result add(AddCoverLetterRequest addCoverLetterRequest) {
        Optional<JobSeeker> optionalJobSeeker=jobSeekerDao.findById(addCoverLetterRequest.getJobSeekerId());
        if(optionalJobSeeker.isEmpty()){
            return new ErrorResult("İş arayan bulunamadı");
        }
        JobSeeker jobSeeker=optionalJobSeeker.get();

        CoverLetter coverLetter=this.modelMapperService.forRequest().map(addCoverLetterRequest,CoverLetter.class);
        coverLetter.setJobSeeker(jobSeeker);
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı Eklendi");
    }
}
