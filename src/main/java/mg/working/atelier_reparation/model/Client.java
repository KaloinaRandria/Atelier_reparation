package mg.working.atelier_reparation.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    String id;
    
    @Column(nullable = false)
    String nom;
    String prenom;

    @Column(unique = true , nullable = false)
    String mail;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("CLI" , "s_client");
    }

}
