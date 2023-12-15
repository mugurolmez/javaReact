package kodlama.io.hrms.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.LOOSE);
        ////loose gevşek mapleme yap veri tabanındakı tum verılerı almayacaksan 5 verının 3 unu maple gibi
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        //standard request attığımda herseyi maple
        return this.modelMapper;
    }


}
