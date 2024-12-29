package mg.working.atelier_reparation.services.materiel;

import mg.working.atelier_reparation.model.materiel.Marque;
import mg.working.atelier_reparation.repository.materiel.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    MarqueRepository marqueRepository;

    public void insertMarque(Marque marque) {
        this.marqueRepository.save(marque);
    }

    public List<Marque> getAllMarques() {
        return this.marqueRepository.findAll();
    }

    public Marque getMarqueById(String id) {
        return this.marqueRepository.findById(id).orElse(null);
    }

    // Méthode pour mettre à jour une marque
    public boolean updateMarque(String id, Marque updatedMarque) {
        if (marqueRepository.existsById(id)) {
            updatedMarque.setId(id); // Assure que l'ID reste le même
            marqueRepository.save(updatedMarque);
            return true;
        }
        return false; // Retourne false si la marque avec l'ID donné n'existe pas
    }

    // Méthode pour supprimer une marque
    public boolean deleteMarque(String id) {
        if (marqueRepository.existsById(id)) {
            marqueRepository.deleteById(id);
            return true;
        }
        return false; // Retourne false si la marque avec l'ID donné n'existe pas
    }
}
