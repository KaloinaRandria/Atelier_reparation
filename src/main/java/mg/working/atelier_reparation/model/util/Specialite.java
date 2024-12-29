package mg.working.atelier_reparation.model.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.services.IdGenerator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specialite")
public class Specialite {
    @Id
    String id;

    @Column(nullable = false)
    String libelle;


    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("SPE","s_specialite");
    }


}
