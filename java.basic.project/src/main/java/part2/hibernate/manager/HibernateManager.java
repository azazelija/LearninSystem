package part2.hibernate.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 18395435
 * @created_at 31/03/2021 - 12:07
 * @project kris-bravo-learnin-system
 */
public class HibernateManager {
    //за нас фабрику будет создавать спринг и вообше способ пипец устаревший
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
