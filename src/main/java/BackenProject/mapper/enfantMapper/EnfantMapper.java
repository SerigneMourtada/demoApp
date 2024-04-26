package BackenProject.mapper.enfantMapper;

import BackenProject.dto.EnfantDTO;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.model.Enfant;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class EnfantMapper {
    private UserMapper userMapper;

    public EnfantDTO asEnfantDTO(Enfant enfant){
        EnfantDTO enfantDTO=new EnfantDTO();
        BeanUtils.copyProperties(enfant,enfantDTO);
        //enfantDTO.setParentDTO(userMapper.asUserDTO(enfant.getParent()));
        return enfantDTO;
    }

    public Enfant asEnfant(EnfantDTO enfantDTO){
        Enfant enfant=new Enfant();
        BeanUtils.copyProperties(enfantDTO,enfant);
        //enfant.setParent(userMapper.asUser(enfantDTO.getParentDTO()));
        return enfant;
    }


}
