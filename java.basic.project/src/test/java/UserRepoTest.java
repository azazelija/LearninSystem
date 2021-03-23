import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import part2.jdbc.connection.ConnectionManager;
import part2.jdbc.dto.User;
import part2.jdbc.repo.UserRepo;

import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

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

        userRepo.createTableDropIfExists();
    }

    @Test
    void testSave() {
        User user = new User();
        user.setFirstName("Kristina");
        user.setLastName("Lapochka");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 15).build();
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        assertDoesNotThrow(() -> (userRepo.save(user)));
    }

    @Test
    void testSaveAll() {
        User user = new User();
        user.setFirstName("Kristina");
        user.setLastName("Lapochka");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 15).build();
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        User user2 = new User();
        user2.setFirstName("KOT");
        user2.setLastName("KOSHMARIK");
        Calendar calendar2 = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2020, 1, 15).build();
        user2.setBirthDate(new Date(calendar2.getTimeInMillis()));

        List<User> list = new LinkedList<>();
        list.add(user);
        list.add(user2);

        assertDoesNotThrow(() -> (userRepo.save(list)));
    }

    @Test
    void testExists() {
        User user = new User();
        user.setFirstName("Kristina");
        user.setLastName("Lapochka");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 15).build();
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        userRepo.save(user);

        assertEquals(true, userRepo.existsById(1L));
        assertEquals(true, userRepo.exists(user));
    }
}