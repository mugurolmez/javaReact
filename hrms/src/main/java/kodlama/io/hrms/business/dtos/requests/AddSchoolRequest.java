package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import kodlama.io.hrms.entities.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor

public class AddSchoolRequest {


    private int jobSeekerId;
    private String schoolName;

    private String department;

    @Pattern(regexp = "^(19\\d{2}|20\\d{2})$", message = "Geçerli bir yıl giriniz")
   @NotNull(message = "Başlangıç Yılı Boş Bırakılamaz")
    private String startYear;

    @Pattern(regexp = "^(\\d{4})?$", message = "geçerli bir yıl giriniz veya boş bırakınız")


    private String yearOfGraduation;




}
