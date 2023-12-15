package kodlama.io.hrms.entities.cvEntities;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="linkedin_address")
@AllArgsConstructor
@NoArgsConstructor
public class LinkedinAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "linkedşn_id")
    private int linkedinId;
    @Column(name = "linkedinAddress")
    private String linkedinAddress;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
