package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdTemporaryEmployerResponse {

    private int temporaryEmployerId;
    private String corporateName;
    private String webSite;
    private String phoneNumber;
    private boolean approvalStatus;

}
