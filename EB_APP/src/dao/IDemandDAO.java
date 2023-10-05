package dao;

import java.util.Optional;

public interface IDemandDAO<T> extends IDataDAO<T> {

    Optional<T> findByNumber(String number);

}
