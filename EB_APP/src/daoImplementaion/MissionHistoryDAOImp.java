package daoImplementaion;

import dao.IMissionHistoryDAO;
import database.Database;
import entities.MissionHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MissionHistoryDAOImp implements IMissionHistoryDAO<MissionHistory> {

    private static final Connection connection = Database.getInstance().getConnection();

    /**
     * @return 
     */
    @Override
    public Optional<List<MissionHistory>> findAll() {
        return Optional.empty();
    }

    /**
     * @param missionHistory 
     * @return
     */
    @Override
    public Optional<MissionHistory> save(MissionHistory missionHistory) {
        String sql = "INSERT INTO mission_history (employee_code, mission_code, started_at, ended_at) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, missionHistory.getEmployee().getCode());
            preparedStatement.setString(2, missionHistory.getMission().getCode());
            preparedStatement.setObject(3, missionHistory.getStartedAt());
            preparedStatement.setObject(4, missionHistory.getEndedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(missionHistory);
    }

    /**
     * @param employeeCode 
     * @param missionCode
     * @param startedAt
     * @return
     */
    @Override
    public boolean delete(String employeeCode, String missionCode, LocalDate startedAt) {
        boolean deleted = false;
        String sql = "DELETE FROM employee WHERE employee_code = ? AND mission_code = ? AND started_at = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeCode);
            preparedStatement.setString(1, missionCode);
            preparedStatement.setObject(1, startedAt);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to delete");
        }
        return deleted;
    }
}
