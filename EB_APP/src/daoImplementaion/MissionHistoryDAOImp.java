package daoImplementaion;

import dao.IMissionHistoryDAO;
import database.Database;
import entities.MissionHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        
    }
}
