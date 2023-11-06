package kodlama.io.hrms.business.dtos.requests;


import jakarta.persistence.*;
import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.entities.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCvRequest {


    private int cvId;
    private int jobSeekerId;



    private List<School> schools;
}
