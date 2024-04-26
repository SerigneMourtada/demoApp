package BackenProject.service.vaccinationService;

import BackenProject.dto.VaccinDTO;
import BackenProject.dto.VaccinationCreationRequest;
import BackenProject.dto.VaccinationDTO;

import java.util.List;

public interface VaccinationService {
    List<VaccinationDTO> readVaccinations();

    VaccinationDTO getVaccinationById(Long vaccinationId);

    VaccinationDTO createVaccination(VaccinationCreationRequest vaccinationCreationRequest);

    VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO);

    void deleteVaccination(Long vaccinationId);

    List<VaccinationDTO> getVaccinationByIdCarnet(Long carnetId);
}
