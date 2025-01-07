package mg.working.atelier_reparation.services;

import mg.working.atelier_reparation.model.view.VOrdinateurClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class VOrdinateurClientService {
    @Autowired
    DataSource dataSource;

    public List<VOrdinateurClient> getClientWithPC() {
        List<VOrdinateurClient> valiny = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            String query = "SELECT * FROM v_ordinateur_client";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            VOrdinateurClient vOrdinateurClient;
            while (rs.next()) {
                vOrdinateurClient = new VOrdinateurClient();
                vOrdinateurClient.setIdClient(rs.getString("id_client"));
                vOrdinateurClient.setNom(rs.getString("nom"));
                vOrdinateurClient.setPrenom(rs.getString("prenom"));
                vOrdinateurClient.setMail(rs.getString("mail"));
                vOrdinateurClient.setMarque(rs.getString("marque"));
                vOrdinateurClient.setModele(rs.getString("modele"));
                valiny.add(vOrdinateurClient);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return valiny;

    }

}
