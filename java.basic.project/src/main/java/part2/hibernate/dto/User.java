package part2.hibernate.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

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
