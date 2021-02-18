package part2.jdbc;

import part2.jdbc.connection.ConnectionManager;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/educationaly";
        String login = "postgres";
        String pass = "123";

        ConnectionManager manager = new ConnectionManager();
        manager.getConnection(url, login, pass);
    }
}
