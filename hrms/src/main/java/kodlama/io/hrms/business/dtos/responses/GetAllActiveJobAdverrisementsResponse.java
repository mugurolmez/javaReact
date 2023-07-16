package kodlama.io.hrms.business.dtos.responses;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.City;
import kodlama.io.hrms.entities.JobDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllActiveJobAdverrisementsResponse {
    private String employerName;
    private String jobDescriptionName;
    private int numberOfPositions;
    private LocalDate releaseDate;
    private LocalDate applicationDeadline;

    //is Active en son silinecek kodlama yaparken hata kontrolü için aktif
    private boolean isActive;

}
