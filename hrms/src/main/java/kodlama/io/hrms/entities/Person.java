package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@Table(name="persons")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @NotNull
    @NotBlank
    @Column(name="name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name="lastname")
    private String lastName;


    @Column(name="birth_date")
    private LocalDate birthDate;


    @Pattern(regexp = "\\d{11}",message ="TC Kimlik No 11 Haneli Sayı Olmalıdır" )
    @Column(name = "nationality_number")
    private String nationalityNumber;

    @Valid
    @OneToOne(cascade = {CascadeType.ALL})//tüm işlemlerin (ekleme, güncelleme, silme) ilişkili tabloya aktarılacağını gösterir.
    @JoinColumn(name = "user_id")
    private User user;
}
