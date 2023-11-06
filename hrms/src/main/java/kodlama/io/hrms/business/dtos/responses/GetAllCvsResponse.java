package kodlama.io.hrms.business.dtos.responses;

import kodlama.io.hrms.entities.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvsResponse {

    private int cvId;

    List<School> schools;


}
