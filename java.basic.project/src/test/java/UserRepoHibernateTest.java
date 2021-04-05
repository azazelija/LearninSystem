import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part2.hibernate.dto.User;
import part2.hibernate.repo.UserRepo;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepoHibernateTest {
    UserRepo userRepoHibernate;

    @BeforeEach
    void setUp() {
        userRepoHibernate = new UserRepo();
        //create table
    }

    @Test
    void testSave() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Kristina2");
        user.setLastName("Lapochka2");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 15).build();
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        assertDoesNotThrow(() -> (userRepoHibernate.save(user)));
    }

    @Test
    void testSaveAll() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Kristina");
        user.setLastName("Lapochka");
        Calendar calendar = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2015, 1, 15).build();
        user.setBirthDate(new Date(calendar.getTimeInMillis()));

        User user2 = new User();
        user2.setId(1L);
        user2.setFirstName("KOT");
        user2.setLastName("KOSHMARIK");
        Calendar calendar2 = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2020, 1, 15).build();
        user2.setBirthDate(new Date(calendar2.getTimeInMillis()));

        List<User> list = new LinkedList<>();
        list.add(user);
        list.add(user2);

        assertDoesNotThrow(() -> (userRepoHibernate.save(list)));
    }
}
