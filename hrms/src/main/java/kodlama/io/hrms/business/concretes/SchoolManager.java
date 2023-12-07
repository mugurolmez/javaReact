package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.CvDao;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.SchoolDao;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class SchoolManager implements SchoolService {



    private SchoolDao schoolDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;
    private CvDao cvDao;
    @Autowired
    public SchoolManager(SchoolDao schoolDao, ModelMapperService modelMapperService, JobSeekerDao jobSeekerDao, CvDao cvDao) {
        this.schoolDao = schoolDao;
        this.modelMapperService = modelMapperService;
        this.jobSeekerDao = jobSeekerDao;
        this.cvDao = cvDao;
    }

    @Override
    public Result add(AddSchoolRequest addSchoolRequest) {


        Optional<JobSeeker> optionalJobSeeker = this.jobSeekerDao.findById(addSchoolRequest.getJobSeekerId());
        if (optionalJobSeeker.isEmpty()) {

            return new ErrorResult("Jobseeker Bulunamadı");
        }
        JobSeeker jobSeeker = optionalJobSeeker.get();

        School school = this.modelMapperService.forRequest().map(addSchoolRequest, School.class);
        school.setSchoolId(0);
        school.setJobSeeker(jobSeeker);

        schoolDao.save(school);

        return new SuccessResult("Okul Bilgileri Eklendi");

    }

    @Override
    public List<GetAllSchoolResponse> getAll() {

        List<School> schools = schoolDao.findAll();


        List<GetAllSchoolResponse> schoolResponses = schools.stream()
                .map(school -> this.modelMapperService.forResponse().map(school, GetAllSchoolResponse.class))
                .collect(Collectors.toList());


        return schoolResponses;
    }


    public DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId) {


        List<School> schools = schoolDao.findAllByJobSeekerJobSeekerId(jobSeekerId);

        // YearOfGraduation boşsa "devam ediyor" olarak değiştirme
        schools.forEach(school -> {
            if (school.getSchoolYearOfGraduation() == null || school.getSchoolYearOfGraduation().isEmpty()) {
                school.setSchoolYearOfGraduation("Devam Ediyor");
            }
        });

        //Sıralama
        List<School> sortedSchools = schools.stream()
                .sorted(Comparator.comparing(School::getSchoolYearOfGraduation, Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();

        //Dönüştürme
        List<GetAllSchoolResponse> schoolResponses = sortedSchools.stream()
                .map(school -> this.modelMapperService.forResponse()
                        .map(school, GetAllSchoolResponse.class)).collect(Collectors.toList());


        return new SuccessDataResult(schoolResponses,"Okullar Listelendi");

    }


}





