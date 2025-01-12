package mg.working.atelier_reparation.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mg.working.atelier_reparation.model.Technicien;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.model.util.Composant;
import mg.working.atelier_reparation.model.util.Reparation;
import mg.working.atelier_reparation.model.util.TypeReparation;
import mg.working.atelier_reparation.services.IdGenerator;
import mg.working.atelier_reparation.services.TechnicienService;
import mg.working.atelier_reparation.services.materiel.OrdinateurService;
import mg.working.atelier_reparation.services.util.ComposantService;
import mg.working.atelier_reparation.services.util.ReparationService;
import mg.working.atelier_reparation.services.util.TypeReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrdinateurController {
    @Autowired
    IdGenerator idGenerator;
    @Autowired
    OrdinateurService ordinateurService;
    @Autowired
    TechnicienService technicienService;
    @Autowired
    TypeReparationService typeReparationService;
    @Autowired
    ComposantService composantService;
    @Autowired
    ReparationService reparationService;

    @GetMapping("/ordinateur/reparation")
    public String goToReparationOrdinateur(HttpServletRequest request,
                                           HttpSession session,
                                           @RequestParam(name = "ordinateur") String ordinateur) {
        Ordinateur ordinateur1 = this.ordinateurService.findOrdinateurById(ordinateur);
        ordinateur1.setIsDiagnostic(true);
        request.setAttribute("ordinateur", ordinateur1);
        this.ordinateurService.insertOrdinateur(ordinateur1);

        List<Technicien> techniciens = this.technicienService.listTechnicien();
        request.setAttribute("techniciens", techniciens);

        List<TypeReparation> typeReparations = this.typeReparationService.getAllTypeReparation();
        request.setAttribute("typeReparations", typeReparations);

        List<Composant> composants = this.composantService.getComposants();
        request.setAttribute("composants", composants);
        return "/home/reparation/insertReparation";
    }

    @PostMapping("/reparation/traitement")
    public String traitementReparation(HttpSession session,
                                       @RequestParam(name = "technicien") String idTechnicien,
                                       @RequestParam(name = "typeReparation") String idTypeReparation,
                                       @RequestParam(name = "composant") String idComposant,
                                       @RequestParam(name = "dateDebut") String dateDebut,
                                       @RequestParam(name = "cout") String cout,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "ordinateur") String idOrdinateur) {
        Reparation reparation = new Reparation();
        reparation.setId(idGenerator);
        reparation.setOrdinateur(this.ordinateurService.findOrdinateurById(idOrdinateur));
        reparation.setDescriptionProbleme(description);
        reparation.setTechnicien(this.technicienService.getTechnicienById(idTechnicien));
        reparation.setTypeReparation(this.typeReparationService.getTypeReparationById(idTypeReparation));
        reparation.setComposant(this.composantService.getComposant(idComposant));
        reparation.setDateDepot(dateDebut);
        reparation.setCoutReparation(cout);

        this.reparationService.insertReparation(reparation);
        return "/home/reparation/listReparation";
    }
}
