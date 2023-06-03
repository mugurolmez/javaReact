package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Table(name = "jobdescriptions")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDescription {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, name = "job_name")
    @NotNull
    @NotBlank

    private String jobName;

}
