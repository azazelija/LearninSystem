package part2.jdbc.repo;

import part2.jdbc.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo implements CrudRepo<User, Long> {

    Connection connection;

    public UserRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO EDUCATION.CLIENT VALUES (nextval('EDUCATION.SERIAL'), ?, ?, ?)")) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setDate(3, user.getBirthDate());

            ps.execute();
        }
        catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends User> S findById(Long aLong) {
        return null;
    }

    @Override
    public User findAll() {
        return null;
    }
}
