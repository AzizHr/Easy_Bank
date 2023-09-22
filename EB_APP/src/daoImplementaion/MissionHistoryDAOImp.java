package daoImplementaion;

import dao.IMissionHistoryDAO;
import entities.MissionHistory;
import java.util.List;
import java.util.Optional;

public class MissionHistoryDAOImp implements IMissionHistoryDAO<MissionHistory> {
    /**
     * @return 
     */
    @Override
    public Optional<List<MissionHistory>> findAll() {
        return Optional.empty();
    }
}
