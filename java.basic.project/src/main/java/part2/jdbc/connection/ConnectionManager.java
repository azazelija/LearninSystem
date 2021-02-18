package part2.jdbc.connection;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class ConnectionManager {

    public Connection getConnection(String url, String login, String pass) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, pass);
        } catch (SQLException e) {
            System.out.println(" Не подключилось как бы :/ ");
        } catch (ClassNotFoundException e) {
            System.out.println("Криво подключила драйвер");
        }
        return connection;
    }
}
