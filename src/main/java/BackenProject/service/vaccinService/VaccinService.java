package BackenProject.service.vaccinService;

import BackenProject.dto.VaccinDTO;

import java.util.List;

public interface VaccinService {
    List<VaccinDTO> readVaccins();

    VaccinDTO getVaccinById(Long vaccinId);

    VaccinDTO createVaccin(VaccinDTO vaccinDTO);

    VaccinDTO updateVaccin(VaccinDTO vaccinDTO);

    void deleteVaccin(Long vaccinId);
}
