package dao;

import entities.Account;
import entities.Person;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;

public interface IAccountDAO<T> {

    Optional<T> save(T t);
    boolean delete(String number);
    boolean updateStatus(accountStatus status, String number);
    Optional<List<T>> findAll();
    Optional<List<T>> findByClient(String code);
    Optional<T> findByNumber(String number);
    Optional<T> findByOperationNumber(String number);
    boolean deposit(double balance, String number);
    boolean withdraw(double balance, String number);
}
