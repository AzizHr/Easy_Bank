package services;

import daoImplementaion.MissionDAOImp;
import entities.Employee;
import entities.Mission;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MissionService {

    private static final MissionDAOImp missionDAOImp = new MissionDAOImp();

    public static void findByCode(String code) {

        Optional<Mission> missionOptional = missionDAOImp.findByCode(code);

        if (missionOptional.isPresent()) {
            Mission mission = missionOptional.get();
            System.out.println("Mission Found : ");
            System.out.println(mission);
        } else {
            System.out.println("No Mission With This Code Found!");
        }
    }

    public static Mission getOne(String code) {

        Optional<Mission> missionOptional = missionDAOImp.findByCode(code);

        return missionOptional.orElse(null);
    }

    public static void save(Mission mission) {

        System.out.println("New Mission Added With Success!");
        missionDAOImp.save(mission).ifPresent(System.out::println);

    }

    public static void delete(String code) {

        if(missionDAOImp.delete(code)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void findAll() {
        List<Mission> missions = missionDAOImp.findAll().orElse(Collections.emptyList());

        if (missions.isEmpty()) {
            System.out.println("No Missions Found!");
        } else {
            missions.forEach(System.out::println);
        }
    }
}
