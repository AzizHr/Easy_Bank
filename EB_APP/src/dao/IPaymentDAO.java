package dao;

import entities.Payment;

import java.util.Optional;

public interface IPaymentDAO<T> {

    Optional<T> save(T t);

}
