package mg.working.atelier_reparation.services.util;


import mg.working.atelier_reparation.model.util.Specialite;
import mg.working.atelier_reparation.repository.util.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteService {
    @Autowired
    SpecialiteRepository specialiteRepository;

    public void insertSpecialite (Specialite specialite){
        this.specialiteRepository.save(specialite);
    }

    public List<Specialite> listSpecialite(){
        return this.specialiteRepository.findAll();
    }
    public Specialite specialite (String id){
        return this.specialiteRepository.getReferenceById(id);
    }
}
