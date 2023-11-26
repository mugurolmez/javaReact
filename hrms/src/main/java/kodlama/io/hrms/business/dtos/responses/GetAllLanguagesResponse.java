package kodlama.io.hrms.business.dtos.responses;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesResponse {

    private int languageId;
    private String languageName;
    private String languageLevel;

}
