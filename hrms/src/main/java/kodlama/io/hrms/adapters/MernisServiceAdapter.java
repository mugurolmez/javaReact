package kodlama.io.hrms.adapters;


import kodlama.io.hrms.business.dtos.requests.AddJobSeekerRequest;
import kodlama.io.hrms.business.rules.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.core.utilities.mernis.IRHKPSPublicSoap12;
import org.springframework.stereotype.Service;






//mernis için easywsdl plugin indir yeni paket aç mernis isminde  link yapıstır java seçerek kur
//File->project structure->modules->"+"->easywsdl klarörünün içindeki jarları projeye ekle
public class MernisServiceAdapter implements JobSeekerCheckService {


    @Override
    public boolean CheckIfRealJobSeeker(AddJobSeekerRequest addJobSeekerRequest) {
        {
            IRHKPSPublicSoap12 mernisClient = new IRHKPSPublicSoap12();


            boolean result ;
            try {
                result = mernisClient.TCKimlikNoDogrula(
                        Long.parseLong(addJobSeekerRequest.getNationalityNumber()),
                        addJobSeekerRequest.getName().toUpperCase(),
                        addJobSeekerRequest.getLastName().toUpperCase(),
                        addJobSeekerRequest.getBirthDate().getYear()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return result;
        }

    }
}
