package services;

import daoImplementaion.MissionHistoryDAOImp;
import entities.MissionHistory;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MissionHistoryService {

    private final MissionHistoryDAOImp missionHistoryDAOImp;

    public MissionHistoryService(MissionHistoryDAOImp instance) {
        missionHistoryDAOImp = instance;
    }

    public  MissionHistory save(MissionHistory missionHistory) {

        return missionHistoryDAOImp.save(missionHistory).orElse(null);

    }

    public  boolean delete(String employeeCode, String missionCode, LocalDate startedAt) {

        return missionHistoryDAOImp.delete(employeeCode, missionCode, startedAt);
    }

    public  List<MissionHistory> findAll() {

        return missionHistoryDAOImp.findAll().orElse(Collections.emptyList());

    }

}
