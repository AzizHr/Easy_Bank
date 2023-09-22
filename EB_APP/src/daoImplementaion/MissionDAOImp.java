package daoImplementaion;

import dao.IMissionDAO;
import entities.Mission;
import java.util.Optional;

public class MissionDAOImp implements IMissionDAO<Mission> {
    /**
     * @param mission 
     * @return
     */
    @Override
    public Optional<Mission> save(Mission mission) {
        return Optional.empty();
    }
}
