package daoImplementaion;

import dao.IMissionDAO;
import database.Database;
import entities.Mission;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class MissionDAOImp implements IMissionDAO<Mission> {

    private static final Connection connection = Database.getInstance().getConnection();

    /**
     * @param mission 
     * @return
     */
    @Override
    public Optional<Mission> save(Mission mission) {
        String sql = "INSERT INTO mission (number, balance, created_at, status, overdraft, client_code, employee_code) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mission.getCode());
            preparedStatement.setString(2, mission.getName());
            preparedStatement.setString(3, mission.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(mission);
    }
}
