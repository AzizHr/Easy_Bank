package helpers;

public class MissionMenu {

    private static final String NEW_MISSION = "Press [1] To Add A New Mission\n";
    private static final String ALL_MISSIONS = "Press [2] To Show All Missions\n";
    private static final String DELETE_MISSION = "Press [3] To Delete A Mission\n";
    private static final String NEW_ASSIGNMENT = "Press [3] To Assign A Mission To An Employee\n";
    private static final String DELETE_ASSIGNMENT = "Press [3] To Delete An Assignment\n";

    public static void show() {
        System.out.println("-----Mission Administration-----\n");

        System.out.println(NEW_MISSION + ALL_MISSIONS + DELETE_MISSION + NEW_ASSIGNMENT + DELETE_ASSIGNMENT);
    }

}
