package kodlama.io.hrms.adapters;


import kodlama.io.hrms.entities.JobSeeker;
import kodlama.io.hrms.mernis.IRHKPSPublicSoap12;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service



//mernis için easywsdl plugin indir yeni paket aç mernis isminde  link yapıstır java seçerek kur
//File->project structure->modules->"+"->easywsdl klarörünün içindeki jarları projeye ekle
public class MernisServiceAdapter implements PersonCheckService {


    @Override
    public boolean CheckIfRealJobSeeker(JobSeeker jobseeker) {
        {
            IRHKPSPublicSoap12 mernisClient = new IRHKPSPublicSoap12();


            boolean result ;
            try {
                result = mernisClient.TCKimlikNoDogrula(
                        Long.parseLong(jobseeker.getPerson().getNationalityNumber()),
                        jobseeker.getPerson().getName().toUpperCase(),
                        jobseeker.getPerson().getLastName().toUpperCase(),
                        jobseeker.getPerson().getBirthDate().getYear()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return result;
        }

    }
}
