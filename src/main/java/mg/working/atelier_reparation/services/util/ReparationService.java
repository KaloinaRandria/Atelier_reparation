package mg.working.atelier_reparation.services.util;

import mg.working.atelier_reparation.model.util.Reparation;
import mg.working.atelier_reparation.repository.util.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationService {
    @Autowired
    ReparationRepository reparationRepository;

    public void insertReparation(Reparation reparation) {
        this.reparationRepository.save(reparation);
    }

    public List<Reparation> getAllReparations() {
        return this.reparationRepository.findAll();
    }
}
