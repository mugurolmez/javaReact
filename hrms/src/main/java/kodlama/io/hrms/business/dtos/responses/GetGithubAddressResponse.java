package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGithubAddressResponse {

    private int githubId;
    private String githubAddress;
    private int jobSeekerId;
}
