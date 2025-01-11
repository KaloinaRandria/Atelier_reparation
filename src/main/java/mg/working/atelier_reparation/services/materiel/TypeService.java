package mg.working.atelier_reparation.services.materiel;

import mg.working.atelier_reparation.model.materiel.Type;
import mg.working.atelier_reparation.repository.materiel.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    TypeRepository typeRepository;

    public Type getTypeById(String id)  {
        return this.typeRepository.findById(id).orElse(null);
    }
}
