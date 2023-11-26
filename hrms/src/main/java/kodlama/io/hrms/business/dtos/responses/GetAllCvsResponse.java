package kodlama.io.hrms.business.dtos.responses;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.School;
import kodlama.io.hrms.entities.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvsResponse {

    private int cvId;
    private int jobSeekerId;
    private List<School> schools;
    private List<WorkExperience> workExperiences;

}
