package BackenProject.mapper.userMapper;

import BackenProject.dto.UserDTO;
import BackenProject.mapper.centreMapper.CentreMapper;
import BackenProject.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {
    private CentreMapper centreMapper;


    public UserDTO asUserDTO(User user){
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        //userDTO.setCentreDTO(centreMapper.asCentreDTO(user.getCentre()));
        return userDTO;
    }

    public User asUser(UserDTO userDTO){
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        //user.setCentre(centreMapper.asCentre(userDTO.getCentreDTO()));
        return user;
    }
}
