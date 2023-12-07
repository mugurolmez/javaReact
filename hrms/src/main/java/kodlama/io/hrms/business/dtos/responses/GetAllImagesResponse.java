package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllImagesResponse {
    private int id;
    private String name;
    private String imageUrl;
    private String imageId;
    private int jobSeekerId;
}
