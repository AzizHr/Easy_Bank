package services;

import daoImplementaion.MissionDAOImp;
import entities.Mission;

import java.util.List;
import java.util.Optional;

public class MissionService {

    private static final MissionDAOImp missionDAOImp = new MissionDAOImp();

    public static Optional<List<Mission>> findAll() {
        return missionDAOImp.findAll();
    }

    public static boolean delete(String code) {
        return missionDAOImp.delete(code);
    }

}
