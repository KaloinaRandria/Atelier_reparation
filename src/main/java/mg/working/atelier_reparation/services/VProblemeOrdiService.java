package mg.working.atelier_reparation.services;

import mg.working.atelier_reparation.model.view.VProblemeOrdi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class VProblemeOrdiService {
    @Autowired
    DataSource dataSource;

    public List<VProblemeOrdi> getOrdinateurByProbleme(String idProbleme) {
        List<VProblemeOrdi> valiny = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            String query = "SELECT * FROM v_probleme_ordinateur WHERE id_probleme = '" + idProbleme + "'";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            VProblemeOrdi vProblemeOrdi ;
            while (resultSet.next()) {
                vProblemeOrdi = new VProblemeOrdi();
                vProblemeOrdi.setIdClient(resultSet.getString("id_client"));
                vProblemeOrdi.setIdOrdinateur(resultSet.getString("id_ordinateur"));
                vProblemeOrdi.setNom(resultSet.getString("nom"));
                vProblemeOrdi.setPrenom(resultSet.getString("prenom"));
                vProblemeOrdi.setMail(resultSet.getString("mail"));
                vProblemeOrdi.setMarque(resultSet.getString("marque"));
                vProblemeOrdi.setModele(resultSet.getString("modele"));
                vProblemeOrdi.setIdProbleme(resultSet.getString("id_probleme"));
                valiny.add(vProblemeOrdi);

            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return valiny;
    }

}
