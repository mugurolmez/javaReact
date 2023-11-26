package kodlama.io.hrms.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobAdvertisementRequest {
    @NotBlank
    @NotNull
    private int employerId;

    @NotBlank
    @NotNull
    private String jobDescriptionFeatures;

    private double minSalary;
    private double maxSalary;
    @NotBlank
    @NotNull
    private int numberOfPositions;

    private LocalDate applicationDeadline;
    @NotBlank
    @NotNull
    private int jobDescriptionId;
    @NotBlank
    @NotNull
    private int cityId;
}
