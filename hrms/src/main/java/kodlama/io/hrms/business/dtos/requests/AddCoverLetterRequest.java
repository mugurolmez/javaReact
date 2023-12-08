package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.JobSeeker;
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
