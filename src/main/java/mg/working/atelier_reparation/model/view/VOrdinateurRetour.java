package mg.working.atelier_reparation.model.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_ordinateur_retour_libelle")
public class VOrdinateurRetour {
    String idReparation;
    String idOrdinateur;
    String nomTechnicien;
    String prenomTechnicien;
    String typeReparation;
    String composant;
    String marque;
    String modele;
}
