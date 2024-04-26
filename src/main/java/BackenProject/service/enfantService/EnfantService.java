package BackenProject.service.enfantService;

import BackenProject.dto.EnfantDTO;

import java.util.List;

public interface EnfantService {
    List<EnfantDTO> readEnfants();

    EnfantDTO getEnfantById(Long enfantId);

    EnfantDTO createEnfant(EnfantDTO enfantDTO);

    EnfantDTO updateEnfant(EnfantDTO enfantDTO);

    void deleteEnfant(Long enfantId);
}
