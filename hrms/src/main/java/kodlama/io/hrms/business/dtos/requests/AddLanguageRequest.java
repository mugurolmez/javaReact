package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kodlama.io.hrms.entities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLanguageRequest {


    private int jobSeekerId;
    @NotNull
    @NotBlank
    private String languageName;
    @Min(value = 1,message = "Seviye 1den küçük olamaz")
    @Max(value = 5,message = "Seviye 5den büyük olamaz")
    private String languageLevel;



}
