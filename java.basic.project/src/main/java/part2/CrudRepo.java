package part2;

public interface CrudRepo<T, ID> {

    <S extends T> S save(S var1);

    <S extends T> Iterable<S> save(Iterable<S> var1);

    T findOne(ID var1);

    boolean existsById(ID var1);

    boolean exists(T var1);

    Iterable<T> findAll();

    long count();

    void deleteById(ID var1);

    void delete(T var1);

    void deleteAll();
}
