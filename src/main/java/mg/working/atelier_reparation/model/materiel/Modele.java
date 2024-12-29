package mg.working.atelier_reparation.model.materiel;

import jakarta.persistence.*;
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
@Table(name = "modele")
public class Modele {
    @Id
    String id;

    @Column(nullable = false)
    String libelle;

    @ManyToOne @JoinColumn(name = "id_marque" , referencedColumnName = "id" ,nullable = false)
    Marque marque;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("MDL" , "s_modele");
    }
}
