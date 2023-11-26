package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployersResponse {
    private int userId;
    private String email;
    private String password;
    private int employerId;
    private String corporateName;
    private String webSite;
    private String phoneNumber;

}
