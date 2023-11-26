package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.dtos.requests.UpdateCvRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllCvsResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.CvDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.SchoolDao;
import kodlama.io.hrms.dataAcces.abstracts.WorkExperienceDao;
import kodlama.io.hrms.entities.Cv;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.School;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CvManager implements CvService {
    private CvDao cvDao;
    private JobSeekerDao jobSeekerDao;
    private SchoolDao schoolDao;
    private WorkExperienceDao workExperienceDao;
    private ModelMapperService modelMapperService;

    public CvManager(CvDao cvDao, SchoolDao schoolDao, WorkExperienceDao workExperienceDao, ModelMapperService modelMapperService, JobSeekerDao jobSeekerDao) {
        this.cvDao = cvDao;
        this.schoolDao = schoolDao;
        this.workExperienceDao = workExperienceDao;
        this.modelMapperService = modelMapperService;
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public List<GetAllCvsResponse> getAll() {
        List<Cv> cvs = cvDao.findAll();

        List<GetAllCvsResponse> getAllCvsResponses = cvs.stream()
                .map(cv -> this.modelMapperService.forResponse()
                        .map(cv, GetAllCvsResponse.class))
                .collect(Collectors.toList());
        return getAllCvsResponses;

    }

    @Override
    public Result update(UpdateCvRequest updateCvRequest) {

;
        return null;

    }
}
