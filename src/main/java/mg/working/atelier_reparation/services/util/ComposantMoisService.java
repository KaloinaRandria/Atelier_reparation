package mg.working.atelier_reparation.services.util;

import mg.working.atelier_reparation.model.util.ComposantMois;
import mg.working.atelier_reparation.repository.util.ComposantMoisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComposantMoisService {
    @Autowired
    ComposantMoisRepository composantMoisRepository;

    public void insertComposantMois(ComposantMois composantMois) {
        this.composantMoisRepository.save(composantMois);
    }

    public List<ComposantMois> getComposantMois(String mois , String annee) {
        return this.composantMoisRepository.findListByMoisAnnee(mois,annee);
    }

    public List<String> getMonthLibelle() {
        List<String> monthLibelle = new ArrayList<String>();
        monthLibelle.add("January");
        monthLibelle.add("February");
        monthLibelle.add("March");
        monthLibelle.add("April");
        monthLibelle.add("May");
        monthLibelle.add("June");
        monthLibelle.add("July");
        monthLibelle.add("August");
        monthLibelle.add("September");
        monthLibelle.add("October");
        monthLibelle.add("November");
        monthLibelle.add("December");

        return monthLibelle;
    }

}
