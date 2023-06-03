package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "companies")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Column(name = "company_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "company_name")
    int companyName;
}
