package mg.working.atelier_reparation.model.util;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.services.IdGenerator;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "composant_mois")
public class ComposantMois {
    @Id
    String id;
    @ManyToOne @JoinColumn(name = "id_composant" , referencedColumnName = "id")
    Composant composant;
    Date date;

    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }

    public void setId(IdGenerator idGenerator) {
        this.id =  idGenerator.generateId("CMM" , "s_composant_mois");
    }
}
