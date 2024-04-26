package BackenProject.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String nom;

    private String prenom;

    private String addresse;

    private String email;

    private String telephone;

    private String password;


    private CentreDTO centreDTO;
}
