package mg.working.atelier_reparation.repository;

import mg.working.atelier_reparation.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien,String> {

}
