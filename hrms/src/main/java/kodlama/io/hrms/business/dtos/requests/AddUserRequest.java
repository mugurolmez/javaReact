package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    @NotNull(message = "Mail Alanı Zorunludur")
    @NotBlank(message = "Mail Alanı Zorunludur")
    @Email(message = "Email formatı Geçerli Değil")
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
