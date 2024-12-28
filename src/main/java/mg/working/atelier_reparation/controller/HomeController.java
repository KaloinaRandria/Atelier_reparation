package mg.working.atelier_reparation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
     @GetMapping("/")
    public String redirectClient(){
        return "index";
    }
}
