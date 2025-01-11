package mg.working.atelier_reparation.model.util;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.services.IdGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "probleme")
public class Probleme {
    @Id
    String id;
    String libelle;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("PBM" , "s_probleme");
    }
}
