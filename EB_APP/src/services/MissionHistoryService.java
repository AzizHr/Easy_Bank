package services;

import daoImplementaion.MissionHistoryDAOImp;
import entities.Mission;
import entities.MissionHistory;

import java.util.Optional;

public class MissionHistoryService {

    private static final MissionHistoryDAOImp missionHistoryDAOImp = new MissionHistoryDAOImp();

    public static Optional<MissionHistory> save(MissionHistory missionHistory) {
        return missionHistoryDAOImp.save(missionHistory);
    }

}
