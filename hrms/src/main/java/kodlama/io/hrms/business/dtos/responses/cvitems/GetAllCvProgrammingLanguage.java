package kodlama.io.hrms.business.dtos.responses.cvitems;

import kodlama.io.hrms.entities.cvEntities.Framework;
import kodlama.io.hrms.entities.cvEntities.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvProgrammingLanguage {

    private List<ProgrammingLanguage> programmingLanguages;

}


