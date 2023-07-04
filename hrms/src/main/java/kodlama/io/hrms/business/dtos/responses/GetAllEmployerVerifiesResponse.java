package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployerVerifiesResponse {
    private int id;
    private int hrmsPersonId;
    private int employerId;
    private int temporaryEmployerId;
    private String comment;
}
