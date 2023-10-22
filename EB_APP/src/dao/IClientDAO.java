package dao;

import entities.Person;

import java.util.Optional;

public interface IClientDAO<T> extends IPersonDAO<T> {

    Optional<T> findByAddress(String address);

}
