package BackenProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heure;

    private String telephone;

    //Etat_Rendez_Vous etat_rendez_vous;


    @ManyToOne
    private User secretaire;

    @ManyToOne
    private Carnet carnet;
}
