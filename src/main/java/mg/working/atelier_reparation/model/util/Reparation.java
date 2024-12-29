package mg.working.atelier_reparation.model.util;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.model.Technicien;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.services.IdGenerator;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reparation")
public class Reparation {
    @Id
    String id;

    @Column(nullable = false)
    String descriptionProbleme;

    @Column(nullable = false)
    Date dateDepot;
    Date dateRetrait;
    double coutReparation;

    @Column(nullable = false)
    int status = -1; //-1 = en attente , 0 = en cours , 1 = termine

    @ManyToOne @JoinColumn(name = "id_ordinateur" , referencedColumnName = "id" , nullable = false)
    Ordinateur ordinateur;

    @ManyToOne @JoinColumn(name = "id_technicien" , referencedColumnName = "id" , nullable = false)
    Technicien technicien;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("REP","s_reparation");
    }
}
