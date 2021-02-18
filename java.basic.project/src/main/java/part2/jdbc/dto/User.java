package part2.jdbc.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class User {

    String firstName;

    String LastName;

    Date birthDate;
}
