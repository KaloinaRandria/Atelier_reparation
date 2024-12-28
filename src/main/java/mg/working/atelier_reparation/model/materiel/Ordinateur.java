package mg.working.atelier_reparation.model.materiel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.model.Client;
import mg.working.atelier_reparation.services.IdGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordinateur")
public class Ordinateur {
    @Id
    String id;

    @Column(nullable = false , unique = true)
    String numSerie;

    @ManyToOne @JoinColumn(name = "id_modele" , referencedColumnName = "id" , nullable = false)
    Modele modele;

    @ManyToOne @JoinColumn(name = "id_client" , referencedColumnName = "id" , nullable = false)
    Client client;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("ORD" , "s_ordinateur");
    }
}
