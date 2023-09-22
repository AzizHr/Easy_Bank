package dao;

import entities.Account;
import entities.Person;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;

public interface IAccountDAO<T> {

    Optional<T> save(T t);
    Optional<Boolean> delete(T t);
    Optional<Boolean> updateStatus(accountStatus status);
    Optional<List<T>> findAll();
    Optional<List<T>> findByClient(Person person);

}
