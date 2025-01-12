package mg.working.atelier_reparation.controller;

import jakarta.servlet.http.HttpServletRequest;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.services.materiel.OrdinateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdinateurController {
    @Autowired
    OrdinateurService ordinateurService;

    @GetMapping("/ordinateur/reparation")
    public String goToReparationOrdinateur(HttpServletRequest request,@RequestParam(name = "ordinateur") String ordinateur) {
        Ordinateur ordinateur1 = this.ordinateurService.findOrdinateurById(ordinateur);
        ordinateur1.setIsDiagnostic(true);

        return "";
    }
}
