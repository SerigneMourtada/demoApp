package BackenProject.mapper.carnetMapper;

import BackenProject.dto.CarnetDTO;
import BackenProject.dto.CentreDTO;
import BackenProject.mapper.enfantMapper.EnfantMapper;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.model.Carnet;
import BackenProject.model.Centre;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class CarnetMapper {
    private UserMapper userMapper;

    private EnfantMapper enfantMapper;

    public CarnetDTO asCarnetDTO(Carnet carnet){
        CarnetDTO carnetDTO=new CarnetDTO();
        BeanUtils.copyProperties(carnet,carnetDTO);
        carnetDTO.setEnfantDTO(enfantMapper.asEnfantDTO(carnet.getEnfant()));
        carnetDTO.setParentDTO(userMapper.asUserDTO(carnet.getParent()));
        return carnetDTO;
    }

    public Carnet asCarnet(CarnetDTO carnetDTO){
        Carnet carnet=new Carnet();
        BeanUtils.copyProperties(carnetDTO,carnet);
        carnet.setEnfant(enfantMapper.asEnfant(carnetDTO.getEnfantDTO()));
        carnet.setParent(userMapper.asUser(carnetDTO.getParentDTO()));
        return  carnet;
    }
}
