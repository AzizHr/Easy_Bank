package dao;

import entities.Person;

import java.util.Optional;

public interface IClientDAO<T> extends IPersonDAO<T> {

    Optional<T> findByCode(String code);

}
