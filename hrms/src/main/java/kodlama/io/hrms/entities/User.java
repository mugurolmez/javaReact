package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue
    private int id;
    @NotBlank
    @NotBlank
    @Column(name="user_name")
    private String name;

    @Column(name="user_lastname")
    private String lastName;

    @Column(name="nationality_id")
    private String nationalityId;

    @Column(name="user_email")
    private String email;

    @Column(name="user_password")
    private String password;
}
