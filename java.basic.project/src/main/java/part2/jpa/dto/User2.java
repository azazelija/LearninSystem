package part2.jpa.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "client")
public class User2 {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "birth_date")
    Date birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User2 user2 = (User2) o;
        return Objects.equals(firstName, user2.firstName) && Objects.equals(lastName, user2.lastName) && Objects.equals(birthDate, user2.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }
}
