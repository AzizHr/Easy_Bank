package dao;

import entities.Account;
import entities.Person;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;

public interface IAccountDAO<T> {

    Optional<T> save(T t);
    boolean delete(String number);
    Optional<Boolean> updateStatus(accountStatus status);
    Optional<List<T>> findAll();
    Optional<List<T>> findByClient(String code);
    Optional<T> findByNumber(String number);
    boolean deposit(double balance, String number);
    boolean withdraw(double balance, String number);
}
