package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Entity
@Table(name="temporary_employers")
@AllArgsConstructor
@NoArgsConstructor
public class TemporaryEmployer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temporary_employer_id")
    private int temporaryEmployerId;

    @Email
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;
    @Column(name = "corporate_name")
    private String corporateName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "approval_status")
    private boolean verifyStatus=false;

}
