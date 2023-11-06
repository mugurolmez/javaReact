package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "job_experiences")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperince {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String companyName;
    private String startDate;
    private String departureDate;

}
