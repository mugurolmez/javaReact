package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.business.dtos.requests.AddWorkExperienceRequest;
import kodlama.io.hrms.business.dtos.responses.GetAllWorkExperiencesResponse;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAcces.abstracts.WorkExperienceDao;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import kodlama.io.hrms.entities.cvEntities.WorkExperience;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkExperienceManager implements WorkExperienceService {
    @Autowired
    private WorkExperienceDao workExperienceDao;
    private ModelMapperService modelMapperService;
    private JobSeekerDao jobSeekerDao;

    @Override
    public Result add(AddWorkExperienceRequest addWorkExperienceRequest) {

        Optional<JobSeeker> optionalJobSeeker = jobSeekerDao.findById(addWorkExperienceRequest.getJobSeekerId());
        if (optionalJobSeeker.isEmpty()) {
            return new ErrorResult("İş Arayan bulunamadı");
        }

        JobSeeker jobSeeker = optionalJobSeeker.get();

        WorkExperience workExperience = this.modelMapperService.forRequest().map(addWorkExperienceRequest, WorkExperience.class);
        workExperience.setWorkExperienceId(0);
        workExperience.setJobSeeker(jobSeeker);


        this.workExperienceDao.save(workExperience);
        return new SuccessResult("İş Tecrübesi Bilgileri Eklendi");
    }

    @Override
    public DataResult findAllByJobSeekerJobSeekerId(int jobSeekerId) {

        List<WorkExperience> workExperiences = this.workExperienceDao.findAllByJobSeekerJobSeekerId(jobSeekerId);

        //  boşsa "devam ediyor" olarak değiştirme
        workExperiences.forEach(workExperience -> {
            if (workExperience.getYearOfDeparture() == null || workExperience.getYearOfDeparture().isEmpty()) {
                workExperience.setYearOfDeparture("Devam Ediyor");
            }
        });

        //Sıralama
        List<WorkExperience> sortedWorkExperiences = workExperiences.stream()
                .sorted(Comparator.comparing(WorkExperience::getYearOfDeparture, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());

        //Dönüştürme
        List<GetAllWorkExperiencesResponse> workExperiencesResponses = sortedWorkExperiences.stream()
                .map(workExperience -> this.modelMapperService.forResponse()
                        .map(workExperience, GetAllWorkExperiencesResponse.class)).collect(Collectors.toList());


        return new SuccessDataResult(workExperiencesResponses, "İş Tecrübeleri Listelendi");
    }

    @Override
    public List<WorkExperience> GetAllCvWorkExperiences(int jobSeekerId) {

        List<WorkExperience> workExperiences = this.workExperienceDao.findAllByJobSeekerJobSeekerId(jobSeekerId);

        //  boşsa "devam ediyor" olarak değiştirme
        workExperiences.forEach(workExperience -> {
            if (workExperience.getYearOfDeparture() == null || workExperience.getYearOfDeparture().isEmpty()) {
                workExperience.setYearOfDeparture("Devam Ediyor");
            }
        });

        //Sıralama
        List<WorkExperience> sortedWorkExperiences = workExperiences.stream()
                .sorted(Comparator.comparing(WorkExperience::getYearOfDeparture, Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();


        return sortedWorkExperiences;

    }
}
