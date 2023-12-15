package kodlama.io.hrms.business.dtos.responses;

import kodlama.io.hrms.entities.cvEntities.Framework;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {

    private int programmingLanguageId;
    private String programmingLanguageName;
}
