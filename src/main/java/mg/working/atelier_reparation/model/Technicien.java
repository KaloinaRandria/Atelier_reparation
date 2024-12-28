package mg.working.atelier_reparation.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.model.util.Specialite;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "technicien")
public class Technicien {
    @Id
    String id;
    String nom;
    String prenom;
    String mail;
    @ManyToOne @JoinColumn(name = "id_specialite",referencedColumnName = "id")
    Specialite specialite;
}
