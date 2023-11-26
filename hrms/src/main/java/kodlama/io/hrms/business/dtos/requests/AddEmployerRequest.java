package kodlama.io.hrms.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployerRequest {

    private String email;
    private String password;
    private String corporateName;
    private String webSite;
    private String phoneNumber;
}
