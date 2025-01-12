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
@Table(name = "v_client_ordinateur_list")
public class VClientOrdinateurList {
    String idOrdinateur;
    String numSerie;
    String idModele;
    String modele;
    String marque;
    String idClient;
    String nomClient;
    String prenomClient;
    String idTypeOrdinateur;
    String TypeOrdinateur;
    String diagnostic;
}
