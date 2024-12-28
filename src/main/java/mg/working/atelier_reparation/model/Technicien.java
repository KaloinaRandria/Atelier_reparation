package mg.working.atelier_reparation.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.model.util.Specialite;
import mg.working.atelier_reparation.services.IdGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "technicien")
public class Technicien {
    @Id
    String id;

    @Column(nullable = false)
    String nom;
    String prenom;

    @Column(nullable = false , unique = true)
    String mail;
    @ManyToOne @JoinColumn(name = "id_specialite",referencedColumnName = "id" , nullable = false)
    Specialite specialite;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("TEC" , "s_technicien");
    }
}
