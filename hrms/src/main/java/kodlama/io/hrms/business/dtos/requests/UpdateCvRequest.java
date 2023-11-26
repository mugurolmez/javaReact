package kodlama.io.hrms.business.dtos.requests;


import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kodlama.io.hrms.entities.Cv;
import kodlama.io.hrms.entities.School;
import kodlama.io.hrms.entities.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCvRequest {

    private int jobSeekerId;

    //school
    private String schoolName;
    private String schoolDepartment;
    private String schoolStartYear;
    private String schoolYearOfGraduation;

    //workExperience
    private String companyName;
    private String jobPosition;
    private String workStartYear;
    private String yearOfDeparture;


}
