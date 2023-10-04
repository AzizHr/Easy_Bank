package dao;

import java.util.List;
import java.util.Optional;

public interface IAgencyDAO<T> extends IDataDAO<T> {

    Optional<T> update(T t);
    Optional<T> findByCode(String code);
    Optional<T> findByAdress(String adress);
    Optional<List<T>> findByEmployee(T t);

}
