package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHrmsPersonResponse {

        private int userId;
        private String email;
        private String password;
        private int personId;
        private String name;
        private String lastName;
        private LocalDate birthDate;
        private String nationalityNumber;
        private int hrmsPersonId;

}
