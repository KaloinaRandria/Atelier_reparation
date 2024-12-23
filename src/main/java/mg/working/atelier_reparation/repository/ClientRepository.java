package mg.working.atelier_reparation.repository;

import mg.working.atelier_reparation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client , String> {
}
