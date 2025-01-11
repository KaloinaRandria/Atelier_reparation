package mg.working.atelier_reparation.controller;

import jakarta.servlet.http.HttpServletRequest;
import mg.working.atelier_reparation.model.view.VOrdinateurClient;
import mg.working.atelier_reparation.model.view.VProblemeOrdi;
import mg.working.atelier_reparation.services.VOrdinateurClientService;
import mg.working.atelier_reparation.services.VProblemeOrdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProblemeController {
    @Autowired
    VProblemeOrdiService vProblemeOrdiService;
    @Autowired
    ProblemeService problemeService;
    @Autowired
    VOrdinateurClientService vOrdinateurClientService;

    @GetMapping("/probleme/ordinateur")
    public String getListOrdiByProbleme(HttpServletRequest request) {
        String idProbleme = request.getParameter("idProbleme");
        if (idProbleme == null || idProbleme.isEmpty() ) {
            List<VOrdinateurClient> ordinateurClients =  this.vOrdinateurClientService.getClientWithPC();
//            List<Probleme> problemes = this.problemeService.getAllProblemes();

            request.setAttribute("ordinateurClients", ordinateurClients);
//            request.setAttribute("problemes", problemes);
            return "/home/ListOrdinateurAvecProbleme";

        }
        List<VProblemeOrdi> vProblemeOrdis = this.vProblemeOrdiService.getOrdinateurByProbleme(idProbleme);
//        List<Probleme> problemes = this.problemeService.getAllProblemes();
        List<VOrdinateurClient> ordinateurClients =  this.vOrdinateurClientService.getClientWithPC();
        request.setAttribute("problemeOrdi", vProblemeOrdis);
//        request.setAttribute("problemes", problemes);
        request.setAttribute("ordinateurClients", ordinateurClients);
        return "/home/ListOrdinateurAvecProbleme";
    }


    @GetMapping("/probleme/redirectOrdinateur")
    public String redirectListOrdinateur() {

        return "redirect:/probleme/ordinateur";
    }

}
