package mg.working.atelier_reparation.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {
    @GetMapping("/home/dashboard")
    public String goToDashboard() {
        return "/home/dashboard";
    }
    @GetMapping("/")
    public String redirectIndex(){
         return "redirect:/home/dashboard";

     }
}
