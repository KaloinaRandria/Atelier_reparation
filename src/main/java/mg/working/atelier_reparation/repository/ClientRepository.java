package mg.working.atelier_reparation.repository;

import mg.working.atelier_reparation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client , String> {
    Client findFirstByOrderByIdDesc();
}
