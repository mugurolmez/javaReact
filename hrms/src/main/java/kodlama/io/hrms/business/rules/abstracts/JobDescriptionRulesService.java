package kodlama.io.hrms.business.rules.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface JobDescriptionRulesService {
    boolean existsByJobDescriptionName(String jobDescriptionName);
}
