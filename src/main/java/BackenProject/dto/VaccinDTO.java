package BackenProject.dto;

import lombok.Data;

@Data
public class VaccinDTO {
    private Long id;

    private String nomVaccin;

    private Long numeroDeLot;

    private String maladie;

    private String age;

    private Boolean status;


}
