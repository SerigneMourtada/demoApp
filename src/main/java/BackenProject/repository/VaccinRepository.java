package BackenProject.repository;

import BackenProject.model.Vaccin;
import BackenProject.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin,Long> {
}
