package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddHrmsPersonRequest {

    @NotNull(message = "Mail Boş olamaz")
    @NotBlank(message = "Mail Boş olamaz")
    @Email(message = "Geçerli bir Email Adresi Giriniz")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Parola Boş olamaz")
    @NotBlank(message = "Parola Boş olamaz")
    private String password;

    @NotNull(message = "Ad Boş olamaz")
    @NotBlank(message = "Ad Boş olamaz")
    private String name;

    @NotNull(message = "Soyadı Boş olamaz")
    @NotBlank(message = "Soyadı Boş olamaz")
    private String lastName;

    @NotNull(message = "Doğum Tarihi Boş olamaz")
    private LocalDate birthDate;

    @Pattern(regexp = "\\d{11}", message = "TC Kimlik No 11 Haneli Sayı Olmalıdır")
    private String nationalityNumber;

}
