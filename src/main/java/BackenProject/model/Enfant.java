package BackenProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor

public class Enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    String prenom;

    String sexe;

    LocalDate dateDeNaissance;


//    @OneToMany(mappedBy = "enfant",cascade = CascadeType.ALL, orphanRemoval = true)
//    List<Consultation> consultations;


    @OneToOne(mappedBy = "enfant",cascade = CascadeType.ALL, orphanRemoval = true)
    Carnet carnet;

    @ManyToOne
    User parent;
}
