package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWorkExperiencesResponse {


    private int workExperienceId;
    private String companyName;
    private String jobPosition;
    private String workStartYear;
    private String yearOfDeparture;
}
