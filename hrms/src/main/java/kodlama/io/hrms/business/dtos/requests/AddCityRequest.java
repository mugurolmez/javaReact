package kodlama.io.hrms.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    private String plateNumber;
    private String Name;
}
