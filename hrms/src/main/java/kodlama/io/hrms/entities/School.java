package kodlama.io.hrms.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Entity
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department")
    private String department;


    @Column(name = "start_year")
    private String startYear;

    @Column(name = "year_of_graduation")
    private String yearOfGraduation;

    @Column(name = "job_seekerId")
    private int jobSeekerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private Cv cv;


}
