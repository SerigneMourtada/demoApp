package BackenProject.repository;

import BackenProject.model.Carnet;
import BackenProject.model.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfantRepository extends JpaRepository<Enfant,Long> {
//    @Query("select c from Enfant e where e.parent.id = ?1")
//    Enfant findEnfantByParent_Id(Long idParent);
}
