package dao;

import entities.RecruitmentHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IRecruitmentHistoryDAO<T, S> {

    Optional<T> assignAnEmployeeToAnAgency(S id1, S id2);
    Optional<T>  assignAnEmployeeToAnotherAgency(S id1, S id2);
    Optional<List<T>> findAll();

}
