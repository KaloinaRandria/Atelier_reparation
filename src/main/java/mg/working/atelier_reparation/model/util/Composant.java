package mg.working.atelier_reparation.model.util;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.services.IdGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "composant")
public class Composant {
    @Id
    String id;
    String libelle;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("CPS" , "s_composant");
    }
}
