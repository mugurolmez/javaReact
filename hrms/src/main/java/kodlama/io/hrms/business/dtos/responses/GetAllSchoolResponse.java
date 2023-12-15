package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSchoolResponse {

    private int SchoolId;
    private String schoolName;
    private String schoolDepartment;
    private String schoolStartYear;
    private String schoolYearOfGraduation;

}
