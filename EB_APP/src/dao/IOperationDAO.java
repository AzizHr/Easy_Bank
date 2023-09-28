package dao;

import entities.Operation;

import java.util.Optional;

public interface IOperationDAO<T> {

    Optional<T> save(T t);
    boolean delete(String number);
    Optional<T> findByNumber(String number);

}
