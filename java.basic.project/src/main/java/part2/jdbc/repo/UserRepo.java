package part2.jdbc.repo;

import part2.jdbc.dto.User;
import part2.jdbc.repo.sequence.SequenceGenerator;

import java.sql.*;

public class UserRepo implements CrudRepo<User, Long> {

    Connection connection;

    SequenceGenerator sequenceGenerator;

    public UserRepo(Connection connection) {
        this.connection = connection;
        sequenceGenerator = new SequenceGenerator(connection);
    }

    public void createTableDropIfExists() {
        try (PreparedStatement ps = connection.prepareStatement("DROP TABLE IF EXISTS EDUCATION.CLIENT;" +
                "CREATE TABLE EDUCATION.CLIENT(id SERIAL PRIMARY KEY," +
                "first_name VARCHAR(255) NOT NULL," +
                "last_name VARCHAR(255) NOT NULL," +
                "birth_date DATE NOT NULL)")) {
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
    }

    @Override
    public <S extends User> S save(S var1) {
        if (exists(var1))
            update(var1);
        else
            create(var1);
        return var1;
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> var1) {
        var1.forEach((v) -> save(v));
        return var1;
    }

    @Override
    public boolean exists(User var1) {
        boolean isExists = false;
        try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*)" +
                "FROM education.client " +
                "WHERE first_name = ? and last_name = ? and birth_date = ?")) {
            ps.setString(1, var1.getFirstName());
            ps.setString(2, var1.getLastName());
            ps.setDate(3, var1.getBirthDate());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                isExists = rs.getBoolean(1);
        } catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
        return isExists;
    }

    @Override
    public boolean existsById(Long var1) {
        boolean isExists = false;
        try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*)" +
                "FROM education.client " +
                "WHERE id = ?")) {
            ps.setLong(1, var1);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                isExists = rs.getBoolean(1);
        } catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
        return isExists;
    }

    @Override
    public User findOne(Long var1) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long var1) {

    }

    @Override
    public void delete(User var1) {

    }

    @Override
    public void deleteAll() {

    }

    private <S extends User> void create(S var1) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO EDUCATION.CLIENT(id, first_name," +
                "last_name, birth_date) VALUES (?,?,?,?)")) {
            ps.setLong(1, sequenceGenerator.getNextUserId());
            ps.setString(2, var1.getFirstName());
            ps.setString(3, var1.getLastName());
            ps.setDate(4, var1.getBirthDate());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
    }

    private <S extends User> void update(S var1) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE EDUCATION.CLIENT " +
                "SET first_name = ?, last_name = ?, birth_date = ?" +
                "WHERE first_name = ? and last_name = ? and birth_date = ?")) {
            ps.setString(1, var1.getFirstName());
            ps.setString(2, var1.getLastName());
            ps.setDate(3, var1.getBirthDate());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Упс неудачная транзация");
            e.printStackTrace();
        }
    }
}
