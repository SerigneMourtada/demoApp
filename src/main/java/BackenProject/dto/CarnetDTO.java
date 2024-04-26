package BackenProject.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarnetDTO {
    private Long id;

    private UserDTO parentDTO;

    private EnfantDTO enfantDTO;

    private List<VaccinationDTO> vaccinationDTOS;
}