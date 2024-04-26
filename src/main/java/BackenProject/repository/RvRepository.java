package BackenProject.repository;

import BackenProject.model.Rv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RvRepository extends JpaRepository<Rv,Long> {
}
