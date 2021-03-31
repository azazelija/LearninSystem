package springDAO.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

/**
 * @author 18395435
 * @created_at 31/03/2021 - 15:24
 * @project kris-bravo-learnin-system
 */
@Getter
@Setter
public class User {
    Long id;

    String firstName;

    String LastName;

    Date birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(LastName, user.LastName) && Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName, birthDate);
    }
}
