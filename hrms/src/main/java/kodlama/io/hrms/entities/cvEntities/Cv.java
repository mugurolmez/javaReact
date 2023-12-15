package kodlama.io.hrms.entities.cvEntities;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cvId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;



}
