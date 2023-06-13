package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name="job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    private  int id;
    private int employerId;
    private String jobDescriptionFeatures;
    private double minSalary;
    private double maxSalary;
    private int numberOfPositions;
    private LocalDate applicationDeadline;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "job_description_id")
    private JobDescription jobDescription;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")//bu classda veri tabanında job_seeker_id olustur
    private JobSeeker jobSeeker;//jobseeker uzerınden baglan bu tabloda bırden fazla kere gecebılir diğer tabloda 1 tane olacak
}
