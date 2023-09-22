package dao;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO<T> {

    Optional<T> save(T t);
    boolean delete(T t);
    boolean update(T t);
    Optional<List<T>> findAll();

}
