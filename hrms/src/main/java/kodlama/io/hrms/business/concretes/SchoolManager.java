package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.dtos.requests.AddSchoolRequest;
import kodlama.io.hrms.business.dtos.responses.cvitems.GetAllCvSchoolResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.SchoolDao;
import kodlama.io.hrms.entities.cvEntities.School;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SchoolManager implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

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

    public DataResult<List<GetAllCvSchoolResponse>> findAllByJobSeeker_JobSeekerId(int jobSeekerId) {
        List<School> schools = this.schoolDao.findAllByJobSeeker_JobSeekerId(jobSeekerId);
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
        List<GetAllCvSchoolResponse> schoolResponses = sortedSchools.stream()
                .map(school -> this.modelMapperService.forResponse()
                        .map(school, GetAllCvSchoolResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(schoolResponses, "Okullar Listelendi");
    }


    @Override
    public List<GetAllCvSchoolResponse> getAllCvSchoolResponses(int jobSeekerId) {
        List<School> schools = this.schoolDao.findAllByJobSeeker_JobSeekerId(jobSeekerId);

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
        List<GetAllCvSchoolResponse> schoolResponses = sortedSchools.stream()
                .map(school -> this.modelMapperService.forResponse()
                        .map(school, GetAllCvSchoolResponse.class)).collect(Collectors.toList());


        return schoolResponses;

    }


}





