package BackenProject.service.enfantService;

import BackenProject.dto.EnfantDTO;
import BackenProject.mapper.carnetMapper.CarnetMapper;
import BackenProject.mapper.enfantMapper.EnfantMapper;
import BackenProject.mapper.userMapper.UserMapper;
import BackenProject.model.Enfant;
import BackenProject.repository.EnfantRepository;
import BackenProject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.text.MessageFormat;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional

public class EnfantServiceImpl implements EnfantService{
    private EnfantRepository enfantRepository;

   private EnfantMapper enfantMapper;

    private UserRepository utilisateurRepository;

    private UserMapper utilisateurMapper;

    private CarnetMapper carnetMapper;




    @Override
    public List<EnfantDTO> readEnfants(){
        List<Enfant> enfantList=enfantRepository.findAll();
        List<EnfantDTO> enfantDTOList=enfantList.stream().map(enfant -> enfantMapper.asEnfantDTO(enfant))
                .collect(Collectors.toList());
        return enfantDTOList;
    }

    @Override
    public EnfantDTO getEnfantById(Long enfantId){
        Enfant enfant=enfantRepository.findById(enfantId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Enfant with id {0}",enfantId)));

        return enfantMapper.asEnfantDTO(enfant);
    }

    @Override
    public EnfantDTO createEnfant(EnfantDTO enfantDTO){
        Enfant enfant=enfantMapper.asEnfant(enfantDTO);
        Enfant enfant1=enfantRepository.save(enfant);
        return enfantMapper.asEnfantDTO(enfant1);
    }

    @Override
    public EnfantDTO updateEnfant(EnfantDTO enfantDTO){
        Enfant enfant=enfantRepository.findById(enfantDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Enfant with id {0}",enfantDTO.getId())));

        return enfantMapper.asEnfantDTO(enfantRepository.save(enfant));
    }

    @Override
    public void deleteEnfant(Long enfantId){
        enfantRepository.deleteById(enfantId);


    }
}
