package kodlama.io.hrms.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployerVerifyRequest {

    private int hrmsPersonId;
    private int temporaryEmployerId;
    private String comment;
}
