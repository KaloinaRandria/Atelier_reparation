package mg.working.atelier_reparation.model.util.stock;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.working.atelier_reparation.model.materiel.Ordinateur;
import mg.working.atelier_reparation.services.IdGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mvt_stock_fille")
public class MvtStockFille {
    @Id @Column(name = "id_mvt_stock_fille")
    String id;
    int entree;
    int sortie;
    Ordinateur ordinateur;
    MvtStock mvtStock;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("MSF", "s_mvt_stock_fille");
    }

    public void setEntree(String entree) {
        this.entree = Integer.parseInt(entree);
    }

    public void setSortie(String sortie) {
        this.sortie = Integer.parseInt(sortie); 
        
    }
}
