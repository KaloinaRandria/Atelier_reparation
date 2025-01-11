package mg.working.atelier_reparation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechnicienController {
    @GetMapping("/home/technicienInsert")
    public String goToTechnicienInsertPage() {
        return "/home/technicien/insertTechnicien";
    }
    @GetMapping("/home/redirectTechnicienInsert")
    public String redirectToTechnicienInsertPage() {
        return "redirect:/home/technicienInsert";
    }
}
