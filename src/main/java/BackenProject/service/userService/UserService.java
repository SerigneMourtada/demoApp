package BackenProject.service.userService;

import BackenProject.dto.UserDTO;
import BackenProject.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> readUtilisateurs();

    UserDTO getUtilisateurById(Long userId);

    UserDTO createUser(UserDTO utilisateurDTO);


    UserDTO updateUtilisateur(UserDTO userDTO);

    void deleteUtilisateur(Long userId);
}
