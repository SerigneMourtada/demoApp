package BackenProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poids;

    private Long temperature;

//    @ManyToOne
//    private Enfant enfant;

    @OneToOne(mappedBy = "consultation",cascade = CascadeType.ALL, orphanRemoval = true)
    private Vaccination vaccination;
}
