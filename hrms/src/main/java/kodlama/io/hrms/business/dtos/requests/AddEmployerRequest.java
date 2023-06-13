package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployerRequest {

    @NotNull(message = "Mail Boş olamaz")
    @NotBlank(message = "Mail Boş olamaz")
    @Email(message = "Geçerli Bir Email Giriniz")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Parola Boş olamaz")
    @NotBlank(message = "Parola Boş olamaz")
    private String password;

    @NotNull(message = "Şirket Adı Boş olamaz")
    @NotBlank(message = "Şirket Adı Boş olamaz")
    private String corporateName;

    @NotNull(message = "Webadresi site Boş olamaz")
    @NotBlank(message = "Web Adresi Boş olamaz")
    private String webSite;


    @NotNull(message = "Telefon Numarası Boş olamaz")
    @NotBlank(message = "Telefon Numarası Boş olamaz")
    @Pattern(regexp = "^\\+90\\s[1-9]\\d{2}\\s\\d{3}\\s\\d{2}\\s\\d{2}$",message = "Geçerli Bir Telefon Numarası Giriniz")
    private String phoneNumber;


}
