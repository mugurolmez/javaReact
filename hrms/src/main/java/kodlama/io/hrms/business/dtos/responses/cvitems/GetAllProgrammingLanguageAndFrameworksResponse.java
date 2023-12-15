package kodlama.io.hrms.business.dtos.responses.cvitems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProgrammingLanguageAndFrameworksResponse {
    private String ProgrammingLanguageName;
    private List<FrameworkResponse> frameWorks;

}
