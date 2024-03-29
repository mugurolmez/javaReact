package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.userEntities.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @Column(name = "job_advertisement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobAdvertisement_id;

    @Column(name = "job_description_features")
    private String jobDescriptionFeatures;
    @Column(name = "min_salary")
    private double minSalary;
    @Column(name = "max_salary")
    private double maxSalary;
    @Column(name = "number_of_position")
    private int numberOfPositions;

    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "application_dead_line")
    private LocalDate applicationDeadline;

    @Column(name="is_active")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_description_id")
    private JobDescription jobDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

   }
