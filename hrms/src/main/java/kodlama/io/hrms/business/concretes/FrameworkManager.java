package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.FrameworkService;
import kodlama.io.hrms.business.dtos.requests.AddFrameworkRequest;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAcces.abstracts.FrameworkDao;
import kodlama.io.hrms.dataAcces.abstracts.ProgrammingLanguageDao;
import kodlama.io.hrms.entities.Framework;
import kodlama.io.hrms.entities.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrameworkManager implements FrameworkService {
    private FrameworkDao frameworkDao;
    private ProgrammingLanguageDao programmingLanguageDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public FrameworkManager(FrameworkDao frameworkDao, ProgrammingLanguageDao programmingLanguageDao, ModelMapperService modelMapperService) {
        this.frameworkDao = frameworkDao;
        this.programmingLanguageDao = programmingLanguageDao;
        this.modelMapperService = modelMapperService;
    }




    @Override
    public Result add(AddFrameworkRequest frameworkRequest) {
        Optional<ProgrammingLanguage> optionalProgrammingLanguage=programmingLanguageDao.findById(frameworkRequest.getProgrammingLanguageId());
       if(optionalProgrammingLanguage.isEmpty()){
           return new ErrorResult("Programala Dili Bulunamadı");
       }
        ProgrammingLanguage programmingLanguage=optionalProgrammingLanguage.get();
       Framework framework=this.modelMapperService.forRequest().map(programmingLanguage, Framework.class);
       framework.setProgrammingLanguage(programmingLanguage);
        this.frameworkDao.save(framework);
        return new SuccessResult("FrameWork Eklendi");
    }
}
