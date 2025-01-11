package mg.working.atelier_reparation.repository.materiel;

import mg.working.atelier_reparation.model.materiel.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, String> {
}
