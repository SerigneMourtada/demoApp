package BackenProject.service.consultationService;

import BackenProject.dto.ConsultationDTO;
import BackenProject.mapper.consultationMapper.ConsultationMapper;
import BackenProject.mapper.enfantMapper.EnfantMapper;
import BackenProject.model.Consultation;
import BackenProject.repository.ConsultationRepository;
import BackenProject.repository.EnfantRepository;
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

public class ConsultationServiceImpl implements ConsultationService{

    private ConsultationRepository consultationRepository;

    private ConsultationMapper consultationMapper;

    private EnfantRepository enfantRepository;

    private EnfantMapper enfantMapper;


    @Override
    public List<ConsultationDTO> readConsultations(){
        List<Consultation> consultations=consultationRepository.findAll();
        List<ConsultationDTO> consultationDTOList=consultations.stream().map(consultation -> consultationMapper.asConsultationDTO(consultation))
                .collect(Collectors.toList());
        return consultationDTOList;
    }

    @Override
    public ConsultationDTO getConsultationById(Long consultationId) {
        Consultation consultation=consultationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Consultation with id {0}", consultationId)));
        return consultationMapper.asConsultationDTO(consultation);
    }

    @Override
    public ConsultationDTO createConsultation(ConsultationDTO consultationDTO){
        Consultation consultation=consultationMapper.asConsultation(consultationDTO);
        Consultation consultation1=consultationRepository.save(consultation);
        return consultationMapper.asConsultationDTO(consultation1);
    }

    @Override
    public ConsultationDTO updateConsultation(ConsultationDTO consultationDTO) {
        return null;
    }


    @Override
    public void deleteConsultation(Long consultationId){
        Consultation consultation=consultationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Consultation with id {0}", consultationId)));
        consultationRepository.delete(consultation);
    }

}
