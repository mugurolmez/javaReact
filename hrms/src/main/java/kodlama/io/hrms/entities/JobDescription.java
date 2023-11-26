package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "job_descriptions")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDescription {
    @Id
    @Column(name = "job_description_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobDescriptionId;


    @Column(unique = true, name = "job_description_name")
    @NotNull
    @NotBlank
    private String jobDescriptionName;


    @OneToMany(mappedBy = "jobDescription")//class ismi
    private List<JobAdvertisement> JobAdvertisementNames;


}
