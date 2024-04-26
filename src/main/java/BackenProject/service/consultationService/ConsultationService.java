package BackenProject.service.consultationService;

import BackenProject.dto.ConsultationDTO;

import java.util.List;

public interface ConsultationService {

    List<ConsultationDTO> readConsultations();

    ConsultationDTO getConsultationById(Long consultationId);

    ConsultationDTO createConsultation(ConsultationDTO consultationDTO);

    ConsultationDTO updateConsultation(ConsultationDTO consultationDTO);

    void deleteConsultation(Long consultationId);
}
