package mg.working.atelier_reparation.services.materiel;

import mg.working.atelier_reparation.model.materiel.Marque;
import mg.working.atelier_reparation.model.materiel.Modele;
import mg.working.atelier_reparation.repository.materiel.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleService {
    @Autowired
    ModeleRepository modeleRepository;

    public void insertModele(Modele modele) {
        this.modeleRepository.save(modele);
    }

    public List<Modele> findAllModele() {
        return this.modeleRepository.findAll();
    }

    public List<Modele> findModeleByMarque(Marque marque) {
        return this.modeleRepository.findModeleByMarque(marque);
    }
}
