package mg.working.atelier_reparation.controller;


import jakarta.servlet.http.HttpServletResponse;
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

    @GetMapping("/client/insertPage")
    public String redirectInsertClient() {
        return "/home/client/insertClient";
    }

    @PostMapping("/client/save")
    public void insertClient(HttpServletResponse response,String nom, String prenom, String mail){
        Client client= new Client();
        client.setId(idGenerator);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setMail(mail);

        try {
            this.clientService.insertClient(client);
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
