package mg.working.atelier_reparation.services.materiel;

import mg.working.atelier_reparation.model.Client;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.repository.materiel.OrdinateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinateurService {
    @Autowired
    OrdinateurRepository ordinateurRepository;

    public void insertOrdinateur(Ordinateur ordinateur) {
        this.ordinateurRepository.save(ordinateur);
    }

    public List<Ordinateur> findAllOrdinateur() {
        return this.ordinateurRepository.findAll();
    }

    public Ordinateur findOrdinateurById(String id) {
        return this.ordinateurRepository.findById(id).orElse(null);
    }

    public List<Ordinateur> findOrdinateurByClient(Client client) {
        return this.ordinateurRepository.findOrdinateurByClient(client);
    }

    public Ordinateur findOrdinateurByNumSerie(String numSerie) {
        return this.ordinateurRepository.findOrdinateurByNumSerie(numSerie);
    }
}
