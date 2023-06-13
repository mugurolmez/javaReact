package kodlama.io.hrms.business.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor

public class AddPersonRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @Pattern(regexp = "\\d{11}",message ="TC Kimlik No 11 Haneli Sayı Olmalıdır" )
    private String nationalityNumber;


}
