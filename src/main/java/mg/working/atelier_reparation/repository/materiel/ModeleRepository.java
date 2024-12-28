package mg.working.atelier_reparation.repository.materiel;

import mg.working.atelier_reparation.model.materiel.Marque;
import mg.working.atelier_reparation.model.materiel.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, String> {
    @Query("select m from Modele m where m.marque = :marque")
    List<Modele> findModeleByMarque(Marque marque);
}
