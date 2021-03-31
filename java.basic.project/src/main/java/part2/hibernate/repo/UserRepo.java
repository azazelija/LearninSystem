package part2.hibernate.repo;

import org.hibernate.Session;
import part2.CrudRepo;
import part2.hibernate.dto.User;
import part2.hibernate.manager.HibernateManager;

import java.util.List;

/**
 * @author 18395435
 * @created_at 31/03/2021 - 14:13
 * @project kris-bravo-learnin-system
 */
public class UserRepo implements CrudRepo<User, Long> {
    @Override
    public <S extends User> S save(S var1) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            if (exists(var1))
                session.save(var1);
            else
                session.update(var1);
            session.getTransaction().commit();
        }
        return var1;
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> var1) {
        var1.forEach(this::save);
        return var1;
    }

    @Override
    public User findOne(Long var1) {
        User user = null;
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            user = session.find(User.class, var1);
        }
        return user;
    }

    @Override
    public boolean existsById(Long var1) {
        return findOne(var1) != null;
    }

    @Override
    public boolean exists(User var1) {
        return existsById(var1.getId());
    }

    @Override
    public Iterable<User> findAll() {
        List userList = null;
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            userList = session.createCriteria(User.class).list();
        }
        return userList;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long var1) {
    }

    @Override
    public void delete(User var1) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(var1);
        }
    }

    @Override
    public void deleteAll() {

    }
}
