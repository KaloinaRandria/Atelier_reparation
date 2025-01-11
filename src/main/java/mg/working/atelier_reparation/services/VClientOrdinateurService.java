package mg.working.atelier_reparation.services;

import mg.working.atelier_reparation.model.view.VClientOrdinateurList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class VClientOrdinateurService {
    @Autowired
    DataSource dataSource;

    public List<VClientOrdinateurList> getListClientOrdinateur() {
        List<VClientOrdinateurList> valiny = new ArrayList<VClientOrdinateurList>();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "select * from v_client_ordinateur_list where diagnostic = 'false'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            VClientOrdinateurList v;
            while (rs.next()) {
                v = new VClientOrdinateurList();
                v.setIdOrdinateur(rs.getString("id_ordinateur"));
                v.setNumSerie(rs.getString("num_serie"));
                v.setIdModele(rs.getString("id_modele"));
                v.setModele(rs.getString("modele"));
                v.setMarque(rs.getString("marque"));
                v.setIdClient(rs.getString("id_client"));
                v.setNomClient(rs.getString("nom_client"));
                v.setPrenomClient(rs.getString("prenom_client"));
                v.setIdTypeOrdinateur(rs.getString("id_type"));
                v.setTypeOrdinateur(rs.getString("type_ordinateur"));
                valiny.add(v);
            }
            ps.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return valiny;
    }
}
