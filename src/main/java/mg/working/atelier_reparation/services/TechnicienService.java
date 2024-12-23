package mg.working.atelier_reparation.services;

import mg.working.atelier_reparation.model.Technicien;
import mg.working.atelier_reparation.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienService {
    @Autowired
    TechnicienRepository technicienRepository;

    public void insertTechnicien(Technicien technicien){
        this.technicienRepository.save(technicien);
    }
    public List<Technicien> listTechnicien(){
        return this.technicienRepository.findAll();
    }
    public Technicien getTechnicienById (String id){
        return this.technicienRepository.getReferenceById(id);
    }
}
