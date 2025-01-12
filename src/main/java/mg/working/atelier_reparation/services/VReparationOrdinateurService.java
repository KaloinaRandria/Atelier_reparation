package mg.working.atelier_reparation.services;

import mg.working.atelier_reparation.model.view.VReparationOrdinateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class VReparationOrdinateurService {
    @Autowired
    DataSource dataSource;


    public String sql(String idComposant , String idTypeOrdinateur , String idTypeReparation) {
        String query = "SELECT * FROM v_reparation_ordinateur_list WHERE 1=1";
        if(!idComposant.equals("")){
            query += " AND id_composant= ? ";
        }
        if(!idTypeOrdinateur.equals("")){
            query += " AND id_ordinateur= ? ";
        }
        if(!idTypeReparation.equals("")){
            query += " AND id_reparation= ? ";
        }

        return query;
    }

    public List<VReparationOrdinateur> getListReparationOrdinateurFiltre(String idComposant , String idTypeOrdinateur , String idTypeReparation) {
        List<VReparationOrdinateur> listReparationOrdinateur = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            String query = this.sql(idComposant , idTypeOrdinateur , idTypeReparation);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int indexParameter = 1;

            if(!idComposant.equals("")){
                preparedStatement.setString(indexParameter, idComposant);
                indexParameter++;
            }
            if(!idTypeOrdinateur.equals("")){
                preparedStatement.setString(indexParameter, idTypeOrdinateur);
                indexParameter++;
            }
            if(!idTypeReparation.equals("")){
                preparedStatement.setString(indexParameter, idTypeReparation);
                indexParameter++;
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            VReparationOrdinateur vReparationOrdinateur;
            while(resultSet.next()){
                vReparationOrdinateur = new VReparationOrdinateur();
                vReparationOrdinateur.setIdReparation(resultSet.getString("id_reparation"));
                vReparationOrdinateur.setCoutReparation(resultSet.getDouble("cout_reparation"));
                vReparationOrdinateur.setDateDepot(resultSet.getDate("date_depot"));
                vReparationOrdinateur.setDateRetrait(resultSet.getDate("date_retrait"));
                vReparationOrdinateur.setDescirption(resultSet.getString("descirption"));
                vReparationOrdinateur.setIdComposant(resultSet.getString("id_composant"));
                vReparationOrdinateur.setComposant(resultSet.getString("composant"));
                vReparationOrdinateur.setIdOrdinateur(resultSet.getString("id_ordinateur"));
                vReparationOrdinateur.setMarque(resultSet.getString("marque"));
                vReparationOrdinateur.setModele(resultSet.getString("modele"));
                vReparationOrdinateur.setTypeOrdinateur(resultSet.getString("type_ordinateur"));
                vReparationOrdinateur.setIdClient(resultSet.getString("id_client"));
                vReparationOrdinateur.setNomClient(resultSet.getString("nom_client"));
                vReparationOrdinateur.setPrenomClient(resultSet.getString("prenom_client"));
                vReparationOrdinateur.setIdTechnicien(resultSet.getString("id_technicien"));
                vReparationOrdinateur.setPrenomTechnicien(resultSet.getString("prenom_technicien"));
                vReparationOrdinateur.setTypeReparation(resultSet.getString("type_reparation"));
                listReparationOrdinateur.add(vReparationOrdinateur);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listReparationOrdinateur;
    }
}
