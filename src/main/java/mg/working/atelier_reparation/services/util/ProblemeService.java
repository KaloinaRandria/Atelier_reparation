package mg.working.atelier_reparation.services.util;

import mg.working.atelier_reparation.model.util.Probleme;
import mg.working.atelier_reparation.repository.util.ProblemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemeService {
    @Autowired
    ProblemeRepository problemeRepository;
    public List<Probleme> getAllProblemes() {
        return this.problemeRepository.findAll();
    }

}
