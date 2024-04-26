package BackenProject.service.userService;

import BackenProject.dto.UserDTO;
import BackenProject.mapper.centreMapper.CentreMapper;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.model.User;
import BackenProject.repository.CentreRepository;
import BackenProject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional

public class UserServiceImpl implements UserService{
    private CentreMapper centreVaccMapper;

    private UserRepository utilisateurRepository;

    private CentreRepository centreRepository;

    private UserMapper utilisateurMapper;



    @Override
    public List<UserDTO> readUtilisateurs(){
        List<User> utilisateurs= utilisateurRepository.findAll();
        List<UserDTO> utilisateurDTOList=utilisateurs.stream().
                map(utilisateur -> utilisateurMapper.asUserDTO(utilisateur))
                .collect(Collectors.toList());
        return utilisateurDTOList;
    }

    @Override
    public UserDTO getUtilisateurById(Long userId){
        User user=utilisateurRepository.findById(userId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Utilisateur with id {0}", userId))));

        return utilisateurMapper.asUserDTO((user));
    }

    @Override
    public UserDTO createUser(UserDTO utilisateurDTO){
        User utilisateur= utilisateurMapper.asUser(utilisateurDTO);
        User utilisateur1=utilisateurRepository.save(utilisateur);
        return utilisateurMapper.asUserDTO(utilisateur1);
    }

    @Override
    public UserDTO updateUtilisateur(UserDTO userDTO) {
        User utilisateur=utilisateurRepository.findById(userDTO.getId()).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Utilisateur with id {0}", userDTO.getId())));

        return utilisateurMapper.asUserDTO(utilisateurRepository.save(utilisateur));

    }

    @Override
    public void deleteUtilisateur(Long userId){
        User utilisateur=utilisateurRepository.findById(userId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Utilisateur with id {0}", userId))));

        utilisateurRepository.delete(utilisateur);
    }
}

