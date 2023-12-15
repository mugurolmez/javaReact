package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLinkedinAddressResponse {
    private int linkedinId;
    private String linkedinAddress;
    private int jobSeekerId;
}
