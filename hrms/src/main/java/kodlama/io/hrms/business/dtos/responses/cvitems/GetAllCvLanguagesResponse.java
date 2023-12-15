package kodlama.io.hrms.business.dtos.responses.cvitems;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCvLanguagesResponse {
    private String languageName;
    private String languageLevel;

}
