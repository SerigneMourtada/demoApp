package BackenProject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VaccinationCreationRequest {

    private LocalDate date;

    private Long nombreDeDose;

    private Long vaccinId;

    private Long medcinId;

    private Long carnetId;

    private String poids;

    private Long temperature;
}
