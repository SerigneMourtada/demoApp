package BackenProject.mapper.consultationMapper;

import BackenProject.dto.ConsultationDTO;
import BackenProject.mapper.enfantMapper.EnfantMapper;
import BackenProject.model.Consultation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultationMapper {
    private EnfantMapper enfantMapper;

    public ConsultationDTO  asConsultationDTO(Consultation consultation){
        ConsultationDTO consultationDTO=new ConsultationDTO();
        BeanUtils.copyProperties(consultation,consultationDTO);
       // consultationDTO.setEnfantDTO(enfantMapper.asEnfantDTO(consultation.getEnfant()));
        return  consultationDTO;
    }

    public Consultation asConsultation(ConsultationDTO consultationDTO){
        Consultation consultation=new Consultation();
        BeanUtils.copyProperties(consultationDTO,consultation);
        //consultation.setEnfant(enfantMapper.asEnfant(consultationDTO.getEnfantDTO()));
        return consultation;
    }
}
