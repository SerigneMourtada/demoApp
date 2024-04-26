package BackenProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomVaccin;

    private Long numeroDeLot;

    private String maladie;

    private String age;

    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Maladie> maladies=new ArrayList<>();

    @OneToMany(mappedBy ="vaccin",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Vaccination> vaccinationList;
}
