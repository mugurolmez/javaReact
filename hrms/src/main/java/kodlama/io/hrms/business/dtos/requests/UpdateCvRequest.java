package kodlama.io.hrms.business.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
