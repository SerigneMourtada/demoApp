package BackenProject.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EnfantDTO {
    private Long id;

    private String nom;

    private String prenom;

    private String sexe;

    private LocalDate dateDeNaissance;

    private UserDTO parentDTO;
}
