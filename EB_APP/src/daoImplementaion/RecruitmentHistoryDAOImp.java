package daoImplementaion;

import dao.IRecruitmentHistoryDAO;
import entities.RecruitmentHistory;
import java.util.List;
import java.util.Optional;

public class RecruitmentHistoryDAOImp implements IRecruitmentHistoryDAO<RecruitmentHistory, String> {

    /**
     * @param agencyCode
     * @param employeeCode
     * @return
     */
    @Override
    public Optional<RecruitmentHistory> assignAnEmployeeToAnAgency(String agencyCode, String employeeCode) {
        return Optional.empty();
    }

    /**
     * @param agencyCode
     * @param employeeCode
     * @return
     */
    @Override
    public Optional<RecruitmentHistory> assignAnEmployeeToAnotherAgency(String agencyCode, String employeeCode) {
        return Optional.empty();
    }

    /**
     * @return
     */
    @Override
    public Optional<List<RecruitmentHistory>> findAll() {
        return Optional.empty();
    }
}
