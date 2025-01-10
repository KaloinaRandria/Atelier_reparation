package mg.working.atelier_reparation.repository.util;

import mg.working.atelier_reparation.model.util.Composant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposantRepository extends JpaRepository<Composant, String> {
}
