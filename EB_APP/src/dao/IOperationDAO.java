package dao;

import entities.Operation;

import java.util.Optional;

public interface IOperationDAO<T> {

    Optional<T> save(T t);
    Optional<Boolean> delete(T t);
    Optional<T> findByNumber(String number);

}
