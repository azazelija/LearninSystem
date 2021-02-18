package part2.jdbc.repo;

public interface CrudRepo<T, ID> {

    void create(T t);

    void update();

    void deleteById(ID id);

    void deleteAll();

    <S extends T> S findById(ID id);

    T findAll();
}
