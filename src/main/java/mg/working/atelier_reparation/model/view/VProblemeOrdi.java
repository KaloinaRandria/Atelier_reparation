package mg.working.atelier_reparation.model.view;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_probleme_ordinateur")
public class VProblemeOrdi {
    String idClient;
    String idOrdinateur;
    String idProbleme;
    String nom;
    String prenom;
    String mail;
    String marque;
    String modele;
    String probleme;
}
