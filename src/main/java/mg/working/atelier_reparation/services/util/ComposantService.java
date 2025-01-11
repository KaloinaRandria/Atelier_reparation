package mg.working.atelier_reparation.services.util;

import mg.working.atelier_reparation.model.util.Composant;
import mg.working.atelier_reparation.repository.util.ComposantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposantService {
    @Autowired
    ComposantRepository composantRepository;

    public List<Composant> getComposants() {
        return composantRepository.findAll();
    }

    public Composant getComposant(String id) {
        return this.composantRepository.findById(id).orElse(null);
    }
}
