package part2.jpa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author 18395435
 * @created_at 31/03/2021 - 14:41
 * @project kris-bravo-learnin-system
 */
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("id")
    Long id;

    @Column("first_name")
    String firstName;

    @Column("last_name")
    String LastName;

    @Column("birth_date")
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
