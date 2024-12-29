package mg.working.atelier_reparation.repository.util;

import mg.working.atelier_reparation.model.util.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, String> {
}
