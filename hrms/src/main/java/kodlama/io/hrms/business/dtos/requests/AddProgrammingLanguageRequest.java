package kodlama.io.hrms.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AddProgrammingLanguageRequest {


    private String programmingName;
    private int jobSeekerId;

}
