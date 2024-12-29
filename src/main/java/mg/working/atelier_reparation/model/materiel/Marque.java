package mg.working.atelier_reparation.model.materiel;

import jakarta.persistence.Column;
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
@Table(name = "marque")
public class Marque {
    @Id
    String id;

    @Column(nullable = false)
    String libelle;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("MAR" , "s_marque");
    }

    public void setId(String id) {
        this.id = id;
    }
}
