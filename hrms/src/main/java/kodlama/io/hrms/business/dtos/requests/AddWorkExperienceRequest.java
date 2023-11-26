package kodlama.io.hrms.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddWorkExperienceRequest {

    private int jobSeekerId;
    private String companyName;
    private String jobPosition;
    private String workStartYear;
    private String yearOfDeparture;

}


