package kodlama.io.hrms.business.dtos.requests;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.Framework;
import kodlama.io.hrms.entities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AddProgrammingLanguageRequest {


    private String name;
    private int jobSeekerId;

}
