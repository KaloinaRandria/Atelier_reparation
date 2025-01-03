package mg.working.atelier_reparation.controller;


import jakarta.servlet.http.HttpServletRequest;
import mg.working.atelier_reparation.model.Client;
import mg.working.atelier_reparation.model.materiel.Modele;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.services.ClientService;
import mg.working.atelier_reparation.services.IdGenerator;
import mg.working.atelier_reparation.services.materiel.MarqueService;
import mg.working.atelier_reparation.services.materiel.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    IdGenerator idGenerator ;
    @Autowired
    MarqueService marqueService;
    @Autowired
    ModeleService modeleService;

    @GetMapping("/client/redirectInsert")
    public String redirectInsertClient() {
        return "redirect:/client/insertClient";
    }

    @GetMapping("/client/insertClient")
    public String goToinsertClient() {
        return "home/client/insertClient";
    }

    @PostMapping("/client/save")
    public String insertClient(@RequestParam(name = "nom") String nom, @RequestParam(name = "prenom") String prenom, @RequestParam(name = "email") String mail){
        Client client= new Client();
        client.setId(idGenerator);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setMail(mail);

        this.clientService.insertClient(client);
        return "redirect:/client/ordi";

    }

    @PostMapping("/client/ordi/save")
    public String insertModele(HttpServletRequest request,@RequestParam(name = "modele") String libelle ,@RequestParam(name = "marque") String idMarque ,@RequestParam(name = "numSerie") String numSerie) {
        Modele modele = new Modele();
        modele.setId(idGenerator);
        modele.setLibelle(libelle);
        modele.setMarque(this.marqueService.getMarqueById(idMarque));

        this.modeleService.insertModele(modele);

        Ordinateur ordinateur = new Ordinateur();
        ordinateur.setId(idGenerator);
        ordinateur.setNumSerie(numSerie);
        ordinateur.setModele(modele);
        ordinateur.setClient(this.clientService.getLastClient());

        request.setAttribute("modele", modele);
        return "redirect:/home/dashboard";
    }


    @GetMapping("/client/ordi")
    public String goToInsertOrdiClient() {
        return "/home/client/insertOrdiClient";
    }
}
