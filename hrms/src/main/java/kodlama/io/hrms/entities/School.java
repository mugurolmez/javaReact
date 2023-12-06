package kodlama.io.hrms.entities;
import jakarta.persistence.*;
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
    @Column(name = "school_id")
    private int SchoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department")
    private String schoolDepartment;


    @Column(name = "start_year")
    private String schoolStartYear;

    @Column(name = "year_of_graduation")
    private String schoolYearOfGraduation;
//gfg
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker ;






}
