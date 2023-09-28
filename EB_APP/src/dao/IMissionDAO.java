package dao;

import entities.Mission;

import java.util.Optional;

public interface IMissionDAO<T> {

    Optional<T> save(T t);

    boolean delete(String code);

}
