package dao;

import entities.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO<T> {

    Optional<T> save(T t);
    Optional<Boolean> delete(T t);
    Optional<Boolean> update(T t);
    Optional<List<T>> findAll();

}
