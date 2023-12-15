package kodlama.io.hrms.entities.cvEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "frameworks")
@AllArgsConstructor
@NoArgsConstructor
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "framework_id")
    private int frameworkId;
    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    @Column(name = "framework_name")
    private String frameworkName;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_language_id")
    private ProgrammingLanguage programmingLanguage;
}
