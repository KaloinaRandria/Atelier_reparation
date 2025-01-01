package mg.working.atelier_reparation.controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mg.working.atelier_reparation.model.Client;
import mg.working.atelier_reparation.services.ClientService;
import mg.working.atelier_reparation.services.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    IdGenerator idGenerator ;

    @GetMapping("/client/redirectInsert")
    public String redirectInsertClient() {
        return "redirect:/client/insertClient";
    }
    @GetMapping("/client/insertClient")
    public String goToInsertClient() {
        return "/home/client/insertClient";
    }

    @PostMapping("/client/save")
    public String insertClient(HttpSession session, String nom, String prenom, String mail){
        Client client= new Client();
        client.setId(idGenerator);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setMail(mail);

        this.clientService.insertClient(client);
        session.setAttribute("client", client);
        return "redirect:/client/insertOrdiClient";

    }

    @GetMapping("/client/ordi")
    public String goToInsertOrdiClient() {
        return "/home/client/insertOrdiClient";
    }
}
