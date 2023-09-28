package services;

import daoImplementaion.MissionDAOImp;
import entities.Mission;

import java.util.Optional;

public class MissionService {

    private static final MissionDAOImp missionDAOImp = new MissionDAOImp();

    public static Optional<Mission> save(Mission mission) {
        return missionDAOImp.save(mission);
    }

    public static boolean delete(String code) {
        return missionDAOImp.delete(code);
    }

}
