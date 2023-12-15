package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.FrameworkService;
import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllCvSchoolResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllProgrammingLanguageAndFrameworksResponse;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetByJobSeekerIdCvResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.cvEntities.Cv;
import kodlama.io.hrms.entities.cvEntities.WorkExperience;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CvManager implements CvService {
    @Autowired
    private JobSeekerDao jobSeekerDao;
    private ModelMapperService modelMapperService;
    private FrameworkService frameworkService;
    private SchoolService schoolService;
    private WorkExperienceService workExperienceService;


    @Override
    public DataResult<GetByJobSeekerIdCvResponse> getAll(int jobSeekerId) {

        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(jobSeekerId);
        if (optionalJobSeeker.isEmpty()) {
            return new ErrorDataResult<>("iş arayan Bulunamadı");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();

        List<WorkExperience> workExperiences = this.workExperienceService.GetAllCvWorkExperiences(jobSeekerId);


        List<GetAllCvSchoolResponse> schools = this.schoolService.getAllCvSchoolResponses(jobSeekerId);
        List<GetAllProgrammingLanguageAndFrameworksResponse> frameworksResponse =
                this.frameworkService.findAllByLanguage_id(jobSeekerId).getData();

        Cv cv = new Cv();
        cv.setJobSeeker(jobSeeker);
        jobSeeker.setWorkExperiences(workExperiences);


        GetByJobSeekerIdCvResponse response = this.modelMapperService.forResponse().map(cv, GetByJobSeekerIdCvResponse.class);
        response.setSchools(schools);
        response.setProgrammingLanguages(frameworksResponse);


        return new SuccessDataResult<>(response, "cv listelendi");
    }
}
