package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllJobSeekersResponse;
import kodlama.io.hrms.business.dtos.responses.GetAllSchoolResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.SchoolDao;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class SchoolManager implements SchoolService {


    private SchoolDao schoolDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao, ModelMapperService modelMapperService, JobSeekerDao jobSeekerDao) {
        this.schoolDao = schoolDao;
        this.modelMapperService = modelMapperService;
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public Result add(AddSchoolRequest addSchoolRequest) {

        //  JobSeeker jobSeeker = jobSeekerDao.findById(addSchoolRequest.getJobSeekerId()).orElse(null);
        // if (jobSeeker == null) {
        //    return new ErrorResult("İş arayan Bulunamadı");
        // }


        School school = this.modelMapperService.forRequest().map(addSchoolRequest, School.class);
        //school.setJobSeeker(jobSeeker);

        this.schoolDao.save(school);
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

    @Override
    public List<GetAllSchoolResponse> findAllByOrderByYearOfGraduationDesc() {

        List<School> schools = schoolDao.findAllByOrderByYearOfGraduationDesc();

        List<GetAllSchoolResponse> schoolResponses = schools.stream()
                .map(school -> this.modelMapperService.forResponse().map(school, GetAllSchoolResponse.class))
                .collect(Collectors.toList());


        return schoolResponses;
    }

    public List<GetAllSchoolResponse> findAllByJobSeekerId(int jobSeekerId) {

        List<School> schools = schoolDao.findAllByJobSeekerId(jobSeekerId);

        // YearOfGraduation boşsa "devam ediyor" olarak değiştirme
        schools.forEach(school -> {
            if (school.getYearOfGraduation() == null || school.getYearOfGraduation().isEmpty()) {
                school.setYearOfGraduation("Devam Ediyor");
            }
        });

        //Sıralama
        List<School> sortedSchools = schools.stream()
                .sorted(Comparator.comparing(School::getYearOfGraduation, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());

        //Dönüştürme
        List<GetAllSchoolResponse> schoolResponses=sortedSchools.stream()
                .map(school->this.modelMapperService.forResponse()
                        .map(school,GetAllSchoolResponse.class)).collect(Collectors.toList());

        return schoolResponses;

    }



}





