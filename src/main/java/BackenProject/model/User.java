package BackenProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String addresse;

    @Column(unique = true)
    private String email;

    private String telephone;

    private String password;

    @ManyToOne
    @JoinColumn(name = "centreVaccination_id")
    private Centre centre;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carnet> carnetList;

    @OneToMany(mappedBy = "medcin")
    private List<Vaccination> vaccinationList;


    @OneToMany(mappedBy = "secretaire",fetch = FetchType.EAGER)
    private List<Rv> rendezVousList;


    @OneToMany(mappedBy = "parent")
    private List<Enfant> enfants=new ArrayList<>();
}
