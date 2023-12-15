package kodlama.io.hrms.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCoverLetterRequest {

    private String CoverLetter;
    private int jobSeekerId;
}
