package kodlama.io.hrms.business.dtos.responses.cvitems;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCvWorkExperienceResponse {

    private String companyName;
    private String jobPosition;
    private String workStartYear;
    private String yearOfDeparture;

}
