package mg.working.atelier_reparation.controller;

import jakarta.servlet.http.HttpServletRequest;
import mg.working.atelier_reparation.model.util.Composant;
import mg.working.atelier_reparation.model.util.ComposantMois;
import mg.working.atelier_reparation.repository.util.ComposantMoisRepository;
import mg.working.atelier_reparation.services.IdGenerator;
import mg.working.atelier_reparation.services.util.ComposantMoisService;
import mg.working.atelier_reparation.services.util.ComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ComposantController {
    @Autowired
    ComposantMoisService composantMoisService;
    @Autowired
    ComposantService composantService;
    @Autowired
    IdGenerator idGenerator;

    @GetMapping("/composant/insert")
    public String goToInsertComposantMois(HttpServletRequest request) {
        List<Composant> composants = this.composantService.getComposants();
        request.setAttribute("composants", composants);
        return "/home/composant/insertComposantMois";
    }

    @GetMapping("/composant/redirectInsert")
    public String redirectToInsertComposantMois() {
        return "redirect:/composant/insert";
    }

    @PostMapping("/composant/save")
    public String saveComposantMois(@RequestParam(name = "composant") String composant,
                                    @RequestParam(name = "date") String date) {
        ComposantMois composantMois = new ComposantMois();
        composantMois.setId(idGenerator);
        composantMois.setComposant(this.composantService.getComposant(composant));
        composantMois.setDate(date);

        this.composantMoisService.insertComposantMois(composantMois);

        return "redirect:/composant/insert";
    }

    @GetMapping("/composantMois/list")
    public String listComposantMois(HttpServletRequest request) {
        String mois = request.getParameter("mois");
        String annee = request.getParameter("annee");
        if (mois != null && !mois.isEmpty() && annee != null) {
            List<ComposantMois> composantMois = this.composantMoisService.getComposantMois(mois, annee);
            request.setAttribute("composantMois", composantMois);
            request.setAttribute("annee", annee);
            request.setAttribute("mois", mois);
        }
        if (mois == null || mois.isEmpty()) {
            List<ComposantMois> composantAnnee =  this.composantMoisService.getComposantAnnee(annee);
            request.setAttribute("composantMois", composantAnnee);
            request.setAttribute("annee", annee);
        }
        List<String> moisList = this.composantMoisService.getMonthLibelle();

        request.setAttribute("moisList", moisList);

        return "/home/composant/listComposantMois";
    }

    @GetMapping("/composantMois/redirectList")
    public String redirectToComposantMois() {
        return "redirect:/composantMois/list";
    }

}
