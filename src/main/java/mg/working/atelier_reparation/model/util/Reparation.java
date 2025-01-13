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
import java.time.LocalDate;

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

    @ManyToOne @JoinColumn(name = "id_ordinateur" , referencedColumnName = "id" , nullable = false)
    Ordinateur ordinateur;
    @ManyToOne @JoinColumn(name = "id_technicien" , referencedColumnName = "id" , nullable = false)
    Technicien technicien;
    @ManyToOne @JoinColumn(name = "id_type_reparation" , referencedColumnName = "id")
    TypeReparation typeReparation;
    @ManyToOne @JoinColumn(name = "id_composant" , referencedColumnName = "id")
    Composant composant;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("REP","s_reparation");
    }

    public void setDateDepot(String date) {
        this.dateDepot = Date.valueOf(date);
    }
    public void setDateRetrait(String date) {
        if (Date.valueOf(date).after(Date.valueOf(LocalDate.now()))) {
            throw new IllegalArgumentException("La date de retrait ne peut pas être dans le futur.");
        }
        this.dateRetrait = Date.valueOf(date);
    }
    public void setCoutReparation(String cout) {
        this.coutReparation = Double.parseDouble(cout);
    }
}
