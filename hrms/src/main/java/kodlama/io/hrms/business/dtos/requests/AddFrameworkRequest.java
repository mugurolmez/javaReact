package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AddFrameworkRequest {

    private String name;
    private int programmingLanguageId;
}
