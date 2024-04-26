package BackenProject.mapper.centreMapper;

import BackenProject.dto.CentreDTO;
import BackenProject.model.Centre;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CentreMapper {

    public CentreDTO asCentreDTO(Centre centre){
        CentreDTO centreDTO=new CentreDTO();
        BeanUtils.copyProperties(centre,centreDTO);
        return centreDTO;
    }


    public Centre asCentre(CentreDTO centreDTO){
        Centre centre=new Centre();
        BeanUtils.copyProperties(centreDTO,centre);
        return centre;
    }
}
