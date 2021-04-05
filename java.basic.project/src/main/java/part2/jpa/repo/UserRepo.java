package part2.jpa.repo;

import part2.CrudRepo;
import part2.jpa.dto.User2;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author 18395435
 * @created_at 31/03/2021 - 14:57
 * @project kris-bravo-learnin-system
 */
public class UserRepo implements CrudRepo<User2, Long> {
    private EntityManager em = Persistence.createEntityManagerFactory("user").createEntityManager();

    @Override
    public <S extends User2> S save(S var1) {
        em.getTransaction().begin();
        em.persist(var1);
        em.getTransaction().commit();
        em.getEntityManagerFactory().close();
        em.close();
        return var1;
    }

    @Override
    public <S extends User2> Iterable<S> save(Iterable<S> var1) {
        return null;
    }

    @Override
    public User2 findOne(Long var1) {
        return null;
    }

    @Override
    public boolean existsById(Long var1) {
        return false;
    }

    @Override
    public boolean exists(User2 var1) {
        return false;
    }

    @Override
    public Iterable<User2> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long var1) {

    }

    @Override
    public void delete(User2 var1) {
        em.getTransaction().begin();
        em.remove(var1);
        em.getTransaction().commit();
    }

    @Override
    public void deleteAll() {

    }
}
