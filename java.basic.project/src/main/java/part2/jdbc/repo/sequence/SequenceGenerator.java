package part2.jdbc.repo.sequence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceGenerator {

    Connection connection;

    public SequenceGenerator(Connection connection) {
        this.connection = connection;
    }

    public Long getNextUserId() {
        Long id = null;
        try (PreparedStatement ps = connection.prepareStatement("SELECT nextval('education.client_id_seq')")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next())
                id = resultSet.getLong(1);
        }
        catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
        return id;
    }
}
