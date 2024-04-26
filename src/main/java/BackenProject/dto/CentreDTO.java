package BackenProject.dto;

import lombok.Data;

import java.time.LocalTime;
@Data
public class CentreDTO {
    private Long id;

    private String nom;

    private String addresse;

    private LocalTime heure_Ouverture;

    private LocalTime heure_De_Fermeture;

    private String email;

}
