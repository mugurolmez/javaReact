package kodlama.io.hrms.business.dtos.responses.cvitems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCvImageResponse {
    private String name;
    private String imageUrl;
    private String imageId;
}
