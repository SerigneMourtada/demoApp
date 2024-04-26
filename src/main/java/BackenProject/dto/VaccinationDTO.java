package BackenProject.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class VaccinationDTO {
    private Long id;

    private LocalDate date;

    private Long nombreDeDose;

    private VaccinDTO vaccinDTO;

    private UserDTO medcinDTO;

    private CarnetDTO carnetDTO;

    private ConsultationDTO consultationDTO;
}
