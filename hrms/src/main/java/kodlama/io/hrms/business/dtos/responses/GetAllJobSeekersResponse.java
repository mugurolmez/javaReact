package kodlama.io.hrms.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllJobSeekersResponse {
    private int userId;
    private String email;
    private int personId;
    private String nationalityNumber;
    private String name; // Bu satır eklenmiştir.
    private String lastName;
    private LocalDate birthDate;
    private int jobSeekerId;
}
