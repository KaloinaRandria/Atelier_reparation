package mg.working.atelier_reparation.model.view;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_reparation_ordinateur_list")
public class VReparationOrdinateur {
    String idReparation;
    double coutReparation;
    Date dateDepot;
    Date dateRetrait;
    String descirption;
    String idComposant;
    String composant;
    String idOrdinateur;
    String ordinateur;
    String marque;
    String modele;
    String typeOrdinateur;
    String idClient;
    String nomClient;
    String prenomClient;
    String idTechnicien;
    String prenomTechnicien;
    String idTypeReparation;
    String typeReparation;

    public void setCoutReparation(String coutReparation) {
        this.coutReparation = Double.parseDouble(coutReparation);
    }

    public void setDateDepot(String dateDepot) {
        this.dateDepot = Date.valueOf(dateDepot);
    }

    public void setDateRetrait(String dateRetrait) {
        this.dateRetrait = Date.valueOf(dateRetrait);
    }
}
