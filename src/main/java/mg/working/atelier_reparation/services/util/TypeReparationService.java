package mg.working.atelier_reparation.services.util;

import mg.working.atelier_reparation.model.util.TypeReparation;
import mg.working.atelier_reparation.repository.util.TypeReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeReparationService {
    @Autowired
    TypeReparationRepository typeReparationRepository;

    public List<TypeReparation> getAllTypeReparation() {
        return this.typeReparationRepository.findAll();
    }

    public TypeReparation getTypeReparationById(String id) {
        return this.typeReparationRepository.findById(id).orElse(null);
    }
}
