package helpers;

public class PrincipalMenu {

    private static final String EMPLOYEE_ADMINISTRATION = "Press [1] To Show Employee Administration Menu\n";
    private static final String CLIENT_ADMINISTRATION = "Press [2] To Show Client Administration Menu\n";
    private static final String ACCOUNT_ADMINISTRATION = "Press [3] To Show Account Administration Menu\n";
    private static final String OPERATION_ADMINISTRATION = "Press [4] To Show Operation Administration Menu\n";
    private static final String MISSION_ADMINISTRATION = "Press [5] To Show Mission Administration Menu\n";
    private static final String AGENCY_ADMINISTRATION = "Press [6] To Show Agency Administration Menu\n";
    private static final String DEMAND_ADMINISTRATION = "Press [7] To Show Demand Administration Menu\n";
    private static final String PAYMENT_ADMINISTRATION = "Press [8] To Show Payment Administration Menu\n";

    public static void show() {
        System.out.println(EMPLOYEE_ADMINISTRATION + CLIENT_ADMINISTRATION + ACCOUNT_ADMINISTRATION + OPERATION_ADMINISTRATION + MISSION_ADMINISTRATION + AGENCY_ADMINISTRATION + DEMAND_ADMINISTRATION + PAYMENT_ADMINISTRATION);
    }

}
