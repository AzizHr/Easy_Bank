package daoImplementaion;

import dao.IMissionDAO;
import database.Database;
import entities.Employee;
import entities.Mission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MissionDAOImp implements IMissionDAO<Mission> {

    private static final Connection connection = Database.getInstance().getConnection();

    /**
     * @param mission 
     * @return
     */
    @Override
    public Optional<Mission> save(Mission mission) {
        return Optional.empty();
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Mission>> findAll() {
        List<Mission> missions = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Mission mission = new Mission();
                mission.setCode(rs.getString(1));
                mission.setName(rs.getString(2));
                mission.setDescription(rs.getString(3));
                missions.add(mission);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(missions);
    }
}
