package helpers;

public class DemandMenu {

    private static final String NEW_DEMAND = "Press [1] To Start A New Simulation\n";
    private static final String ALL_DEMANDS = "Press [2] To Show All Demands\n";
    private static final String FIND_DEMAND_BY_NUMBER = "Press [3] To Find A Demand By Number\n";
    private static final String UPDATE_DEMAND_STATUS = "Press [4] To Update A Demand Status\n";
    private static final String DELETE_DEMAND = "Press [6] To Delete A Demand\n";

    public static void show() {
        System.out.println("-----Demand Administration-----\n");

        System.out.println(NEW_DEMAND + ALL_DEMANDS + FIND_DEMAND_BY_NUMBER + UPDATE_DEMAND_STATUS + DELETE_DEMAND);
    }

}
