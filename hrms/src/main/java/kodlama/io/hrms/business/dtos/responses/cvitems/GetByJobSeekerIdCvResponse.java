package kodlama.io.hrms.business.dtos.responses.cvitems;

import kodlama.io.hrms.business.dtos.responses.GetGithubAddressResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByJobSeekerIdCvResponse {

    private String JobSeekerName;
    private String JobSeekerLastName;
    private String JobSeekerEmail;
    private List<GetAllProgrammingLanguageAndFrameworksResponse> programmingLanguages;
    private List<GetAllCvWorkExperienceResponse> workExperiences;
    private List<GetAllCvLanguagesResponse> languagesResponse;
    private GetCvGithubAddressResponse githubAddress;
    private GetCvLinkedinAddressResponse linkedinAddress;
    private GetAllCvImageResponse imageResponse;
    private List<GetAllCvSchoolResponse> schools;
    private GetCvCoverLetterResponse coverLetter;



}
