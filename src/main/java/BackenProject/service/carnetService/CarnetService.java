package BackenProject.service.carnetService;

import BackenProject.dto.CarnetDTO;
import BackenProject.dto.EnfantDTO;
import BackenProject.dto.VaccinationDTO;

import java.util.List;

public interface CarnetService {

    List<CarnetDTO> readCarnets();

    List<CarnetDTO> getCarnetsById(Long idParent);

    CarnetDTO getCarnetByEnfantId(Long idEnfant);

    CarnetDTO createCarnet(EnfantDTO enfantDTO, Long idParent);

    CarnetDTO updateCarnet(CarnetDTO CarnetDTODto);

    void deleteCarnet(Long CarnetDTOId);

    void ajouterVaccination(VaccinationDTO vaccinationDTO,Long carnetId);

    void  enleverVaccination(Long vaccinationId);
}
