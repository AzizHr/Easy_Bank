package helpers;

public class EmployeeMenu {

    private static final String NEW_EMPLOYEE = "Press [1] To Add A New Employee\n";
    private static final String ALL_EMPLOYEES = "Press [2] To Show All Employees\n";
    private static final String FIND_EMPLOYEE_BY_CODE = "Press [3] To Find An Employee By Code\n";
    private static final String UPDATE_EMPLOYEE = "Press [4] To Update An Employee\n";
    private static final String FIND_EMPLOYEE_BY_PHONE_NUMBER = "Press [5] To Find An Employee By Phone Number\n";
    private static final String DELETE_EMPLOYEE = "Press [6] To Delete An Employee\n";
    private static final String ASSIGN_AN_EMPLOYEE_TO_AN_AGENCY = "Press [7] To Assign An Employee To An Agency\n";
    private static final String ASSIGN_AN_EMPLOYEE_TO_ANOTHER_AGENCY = "Press [8] To Assign An Employee To Another Agency\n";

    public static void show() {
        System.out.println("-----Employee Administration-----\n");

        System.out.println(NEW_EMPLOYEE + ALL_EMPLOYEES + FIND_EMPLOYEE_BY_CODE + UPDATE_EMPLOYEE + FIND_EMPLOYEE_BY_PHONE_NUMBER + DELETE_EMPLOYEE + ASSIGN_AN_EMPLOYEE_TO_AN_AGENCY + ASSIGN_AN_EMPLOYEE_TO_ANOTHER_AGENCY);
    }

}
