package kodlama.io.hrms.entities.cvEntities;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="github_address")
@AllArgsConstructor
@NoArgsConstructor
public class GithubAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "github_id")
    private int githubId;
    @Column(name = "address")
    private String githubAddress;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
