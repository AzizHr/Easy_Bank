package services;

import daoImplementaion.MissionHistoryDAOImp;
import entities.Employee;
import entities.MissionHistory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class MissionHistoryService {

    private static MissionHistoryDAOImp missionHistoryDAOImp;

    public MissionHistoryService(MissionHistoryDAOImp instance) {
        missionHistoryDAOImp = instance;
    }

    public static void save(MissionHistory missionHistory) {

        System.out.println("New Assignment Added With Success!");
        missionHistoryDAOImp.save(missionHistory).ifPresent(System.out::println);

    }

    public static void delete(String employeeCode, String missionCode, LocalDate startedAt) {

        if(missionHistoryDAOImp.delete(employeeCode, missionCode, startedAt)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void findAll() {
        List<MissionHistory> missionHistories = missionHistoryDAOImp.findAll().orElse(Collections.emptyList());

        if (missionHistories.isEmpty()) {
            System.out.println("No Assignments Found!");
        } else {
            missionHistories.forEach(System.out::println);
        }
    }

}
