import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part2.jdbc.connection.ConnectionManager;
import part2.jdbc.repo.sequence.SequenceGenerator;
import part2.jpa.dto.User2;
import part2.jpa.repo.UserRepo;

import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class User2RepoJpaTest {
    UserRepo userRepoJpa;
    SequenceGenerator sequenceGenerator;

    @BeforeEach
    void setUp() {
        String url = "jdbc:postgresql://localhost:5432/educationaly";
        String login = "postgres";
        String pass = "123";

        ConnectionManager manager = new ConnectionManager();
        Connection connection = manager.getConnection(url, login, pass);
        userRepoJpa = new UserRepo();
        sequenceGenerator = new SequenceGenerator(connection);
        //create table
    }

    @Test
    void testSave() {
        User2 user2 = new User2();
        user2.setId(sequenceGenerator.getNextUserId());
        user2.setFirstName("Kristina3");
        user2.setLastName("Lapochka3");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 16).build();
        user2.setBirthDate(new Date(calendar.getTimeInMillis()));

        assertDoesNotThrow(() -> (userRepoJpa.save(user2)));
    }

    @Test
    void testSaveAll() {
        User2 user = new User2();
        user.setId(1L);
        user.setFirstName("Kristina");
        user.setLastName("Lapochka");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 15).build();
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        User2 user2 = new User2();
        user2.setId(1L);
        user2.setFirstName("KOT");
        user2.setLastName("KOSHMARIK");
        Calendar calendar2 = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2020, 1, 15).build();
        user2.setBirthDate(new Date(calendar2.getTimeInMillis()));

        List<User2> list = new LinkedList<>();
        list.add(user);
        list.add(user2);

        assertDoesNotThrow(() -> (userRepoJpa.save(list)));
    }
}
