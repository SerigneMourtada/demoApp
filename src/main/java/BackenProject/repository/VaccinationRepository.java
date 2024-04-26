package BackenProject.repository;

import BackenProject.dto.VaccinationDTO;
import BackenProject.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination,Long> {
    @Query("select v from Vaccination v where v.carnet.id = ?1")
    List<Vaccination> getVaccinationByCarnetId(Long carnetId);
}
