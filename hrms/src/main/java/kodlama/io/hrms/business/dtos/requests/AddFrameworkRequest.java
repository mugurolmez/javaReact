package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AddFrameworkRequest {

    private int jobSeekerId;
    private String frameworkName;
    private int programmingLanguageId;


}
