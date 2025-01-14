package mg.working.atelier_reparation.repository.util;

import mg.working.atelier_reparation.model.util.ComposantMois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComposantMoisRepository extends JpaRepository<ComposantMois, String> {
    @Query("select c from ComposantMois c where YEAR(c.date) = :annee AND MONTH(c.date) = :mois")
    List<ComposantMois> findListByMoisAnnee(String mois , String annee);
}
