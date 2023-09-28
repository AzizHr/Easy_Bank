package dao;

import entities.Mission;

import java.util.List;
import java.util.Optional;

public interface IMissionDAO<T> {

    Optional<T> save(T t);
    Optional<List<Mission>> findAll();

    boolean delete(String code);

}
