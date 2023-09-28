package services;

import daoImplementaion.MissionHistoryDAOImp;
import entities.MissionHistory;

import java.time.LocalDate;
import java.util.Optional;

public class MissionHistoryService {

    private static final MissionHistoryDAOImp missionHistoryDAOImp = new MissionHistoryDAOImp();

    public static Optional<MissionHistory> save(MissionHistory missionHistory) {
        return missionHistoryDAOImp.save(missionHistory);
    }

    public static boolean delete(String employeeCode, String missionCode, LocalDate startedAt) {
        return missionHistoryDAOImp.delete(employeeCode, missionCode, startedAt);
    }
}
