package dao;

import entities.RecruitmentHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IRecruitmentHistoryDAO<T> {

    Optional<T> assignAnEmployeeToAnAgency(T t);
    Optional<T>  assignAnEmployeeToAnotherAgency(T t);
    Optional<List<T>> findAll();

}
