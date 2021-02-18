import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part2.jdbc.connection.ConnectionManager;
import part2.jdbc.dto.User;
import part2.jdbc.repo.UserRepo;

import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    Connection connection;
    UserRepo userRepo;

    @BeforeEach
    void setUp() {
        String url = "jdbc:postgresql://localhost:5432/educationaly";
        String login = "postgres";
        String pass = "123";

        ConnectionManager manager = new ConnectionManager();
        connection = manager.getConnection(url, login, pass);
        userRepo = new UserRepo(connection);
    }

    @Test
    void create() {
        User user = new User();
        user.setFirstName("Masha");
        user.setLastName("Kakasha");
        Calendar calendar = new GregorianCalendar(2001, 3, 15);
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        userRepo.create(user);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }
}