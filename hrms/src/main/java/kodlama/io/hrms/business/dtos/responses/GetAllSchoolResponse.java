package kodlama.io.hrms.business.dtos.responses;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSchoolResponse {

    private int id;
    private int jobSeekerId;
    private String schoolName;
    private String department;
    private String startYear;
    private String yearOfGraduation;

    private int cvId;
}
