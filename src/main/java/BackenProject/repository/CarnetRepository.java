package BackenProject.repository;

import BackenProject.model.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet,Long> {

    @Query("select c from Carnet c where c.parent.id = ?1")
    List<Carnet> findCarnetByParent_Id(Long idParent);

    @Query("select c from Carnet c where c.enfant.id = ?1")
    Carnet findCarnetByEnfant_Id(Long idEnfant);
}
