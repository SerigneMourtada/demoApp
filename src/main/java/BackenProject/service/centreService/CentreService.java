package BackenProject.service.centreService;

import BackenProject.dto.CentreDTO;

import java.util.List;

public interface CentreService {
    List<CentreDTO> getAllCentre();


    CentreDTO saveCentreVaccination(CentreDTO CentreDTO);

    CentreDTO getCentreById(Long centreId)   ;

    void deleteCentre(Long id);

    CentreDTO updateCentre(CentreDTO centreDTO);
}
