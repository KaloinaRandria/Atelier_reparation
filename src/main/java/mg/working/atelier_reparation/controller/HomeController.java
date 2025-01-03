package mg.working.atelier_reparation.controller;

import mg.working.atelier_reparation.model.materiel.Marque;
import mg.working.atelier_reparation.services.IdGenerator;
import mg.working.atelier_reparation.services.materiel.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
    @Autowired
    IdGenerator idGenerator;
    @Autowired
    MarqueService marqueService;

    @GetMapping("/home/dashboard")
    public String goToDashboard() {
        return "/home/dashboard";
    }
    @GetMapping("/")
    public String redirectIndex(){
         return "redirect:/home/dashboard";

     }

     @GetMapping("/home/marque")
     public String goToBrandPage() {
        return "/home/brandPage";
     }

     @GetMapping("/home/redirectMarque")
     public String redirectBrandPage(){
        return "redirect:/home/marque";
     }

     @PostMapping("/home/marque/save")
     public String addNewBrand(@RequestParam(name = "marque") String marque) {
         Marque brand = new Marque();
         brand.setId(idGenerator);
         brand.setLibelle(marque);

         this.marqueService.insertMarque(brand);

         return "redirect:/home/marque";
     }
}
