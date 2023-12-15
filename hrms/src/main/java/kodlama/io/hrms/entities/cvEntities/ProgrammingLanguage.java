package kodlama.io.hrms.entities.cvEntities;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@Entity
@Table(name = "programming_languages")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programming_language_id")
    private int programmingLanguageId;

    @Column(name = "programming_language_name")
    private String programmingLanguageName;


    @OneToMany(mappedBy = "programmingLanguage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Framework> frameworks;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

}
