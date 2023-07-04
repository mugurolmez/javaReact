package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="employer_verify")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private List<HrmsPerson> hrmsPersons;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "temporary_employer_id")
    private TemporaryEmployer temporaryEmployer;

    private String comment;

}
