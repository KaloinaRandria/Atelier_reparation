package mg.working.atelier_reparation.model.util.stock;

import java.sql.Date;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mvt_stock")
public class MvtStock {
    @Id @Column(name = "id_mvt_stock")
    String id;
    String libelle;
    Date dateMvt;

    public void setId(IdGenerator idGenerator) {
        this.id = idGenerator.generateId("MVT", "s_mvt_stock");
    }

    public void setDateMvt(String date) {
        this.dateMvt = Date.valueOf(date);
    }
}
