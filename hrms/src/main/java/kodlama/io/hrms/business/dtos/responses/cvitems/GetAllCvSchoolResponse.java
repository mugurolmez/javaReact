package kodlama.io.hrms.business.dtos.responses.cvitems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCvSchoolResponse{
        private String schoolName;
        private String schoolDepartment;
        private String schoolStartYear;
        private String schoolYearOfGraduation;
}
