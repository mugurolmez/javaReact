package kodlama.io.hrms.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeactiveJobAdvertisementRequest {
    @NotNull
    @NotBlank
    private int employerId;
    @NotNull
    @NotBlank
    private int jobAdvertisementId;
}
