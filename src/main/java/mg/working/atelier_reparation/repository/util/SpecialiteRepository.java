package mg.working.atelier_reparation.repository.util;


import mg.working.atelier_reparation.model.util.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SpecialiteRepository extends JpaRepository<Specialite,String> {

}
