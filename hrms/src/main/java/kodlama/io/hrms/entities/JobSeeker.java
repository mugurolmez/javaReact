package kodlama.io.hrms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name="job_seeker_id", referencedColumnName = "id")
//@EqualsAndHashCode(callSuper=false)
public class JobSeeker {

    @Id
    @Column(name = "jobSeeker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int jobSeekerId;


    @Valid
    @OneToOne(cascade = {CascadeType.ALL})//birebir ilişkide ilişkili tabloda ki id silinirse jobseekerde silinecek
    @JoinColumn(name = "person_id")
    private Person person;

}
