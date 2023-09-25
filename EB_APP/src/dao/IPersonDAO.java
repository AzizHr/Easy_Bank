package dao;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO<T> {

    Optional<T> save(T t);
    boolean delete(T t);
    int update(T t);
    Optional<List<T>> findAll();
    Optional<T> findByCode(String code);

}
