package springDAO.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springDAO.dto.User;

/**
 * @author 18395435
 * @created_at 31/03/2021 - 15:26
 * @project kris-bravo-learnin-system
 */
@Component
public class UserRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User save(User user) {

    }
}
