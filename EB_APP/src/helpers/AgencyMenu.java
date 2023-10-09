package helpers;

public class AgencyMenu {

    private static final String NEW_AGENCY = "Press [1] To Add A New Agency\n";
    private static final String ALL_AGENCIES = "Press [2] To Show All Agencies\n";
    private static final String FIND_AGENCY_BY_CODE = "Press [3] To Find An Agency By Code\n";
    private static final String UPDATE_AGENCY = "Press [4] To Update An Agency\n";
    private static final String FIND_AGENCY_BY_ADRESS = "Press [5] To Find An Agency By Adress\n";
    private static final String FIND_AGENCY_BY_EMPLOYEE = "Press [5] To Find An Agency By Employee\n";
    private static final String DELETE_AGENCY = "Press [6] To Delete An Agency\n";

    public static void show() {
        System.out.println("-----Agency Administration-----\n");

        System.out.println(NEW_AGENCY + ALL_AGENCIES + FIND_AGENCY_BY_CODE + UPDATE_AGENCY + FIND_AGENCY_BY_ADRESS + FIND_AGENCY_BY_EMPLOYEE + DELETE_AGENCY);
    }

}
