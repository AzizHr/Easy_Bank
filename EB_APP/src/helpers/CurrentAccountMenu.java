package helpers;

public class CurrentAccountMenu {

    private static final String NEW_CURRENT_ACCOUNT = "Press [1] To Add A New Current Account\n";
    private static final String ALL_CURRENT_ACCOUNTS = "Press [2] To Show All Current Accounts\n";
    private static final String FIND_CURRENT_ACCOUNT_BY_CLIENT_CODE = "Press [3] To Find An Current Account By Client Code\n";
    private static final String UPDATE_CURRENT_ACCOUNT = "Press [4] To Update A Current Account\n";
    private static final String FIND_CURRENT_ACCOUNT_BY_OPERATION_NUMBER = "Press [5] To Find A Current Account By Operation Number\n";
    private static final String DELETE_CURRENT_ACCOUNT = "Press [6] To Delete A Current Account\n";
    private static final String UPDATE_CURRENT_ACCOUNT_STATUS = "Press [7] To Update A Current Account Status\n";

    public static void show() {
        System.out.println("-----Current Account Administration-----\n");

        System.out.println(NEW_CURRENT_ACCOUNT + ALL_CURRENT_ACCOUNTS + FIND_CURRENT_ACCOUNT_BY_CLIENT_CODE + UPDATE_CURRENT_ACCOUNT+ FIND_CURRENT_ACCOUNT_BY_OPERATION_NUMBER + DELETE_CURRENT_ACCOUNT + UPDATE_CURRENT_ACCOUNT_STATUS);
    }

}
