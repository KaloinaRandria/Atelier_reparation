package mg.working.atelier_reparation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class IdGenerator {
    @Autowired
    private DataSource dataSource;

    public String generateId(String productIdPrefix , String sequenceName) {
        String productId = "";
        try {
            Connection connection = this.dataSource.getConnection();
            String query = "SELECT nextval(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, sequenceName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                productId = productIdPrefix + String.format("%04d", resultSet.getInt(1));
            } else {
                throw new SQLException("Impossible de recuperer la prochaine valeur de la sequence");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productId;
    }
}
