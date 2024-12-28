package mg.working.atelier_reparation.repository.materiel;

import mg.working.atelier_reparation.model.Client;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdinateurRepository extends JpaRepository<Ordinateur, String> {
    @Query("select o from Ordinateur o where o.numSerie = :numSerie")
    Ordinateur findOrdinateurByNumSerie(String numSerie);

    @Query("select o from Ordinateur o where o.client = :client")
    List<Ordinateur> findOrdinateurByClient(Client client);
}
