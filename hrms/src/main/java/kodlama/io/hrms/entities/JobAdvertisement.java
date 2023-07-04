package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @Column(name = "job_advertisement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobAdvertisement_id;
    @Column(name = "employer_id")
    private int employerId;
    @Column(name = "job_description_features")
    private String jobDescriptionFeatures;
    @Column(name = "min_salary")
    private double minSalary;
    @Column(name = "max_salary")
    private double maxSalary;
    @Column(name = "number_of_position")
    private int numberOfPositions;
    @Column(name = "application_dead_line")
    private LocalDate applicationDeadline;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_description_id")
    private JobDescription jobDescription;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")//bu classda veri tabanında job_seeker_id olustur
    private JobSeeker jobSeeker;//jobseeker uzerınden baglan bu tabloda bırden fazla kere gecebılir diğer tabloda 1 tane olacak
}
