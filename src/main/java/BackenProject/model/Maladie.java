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
public class Maladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMaladie;

    @ManyToMany(mappedBy = "maladies",fetch = FetchType.EAGER)
    private List<Vaccin> vaccinList=new ArrayList<>();

}
