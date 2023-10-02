package helpers;

public class SavingAccountMenu {

    private static final String NEW_SAVING_ACCOUNT = "Press [1] To Add A New Saving Account\n";
    private static final String ALL_SAVING_ACCOUNTS = "Press [2] To Show All Saving Accounts\n";
    private static final String FIND_SAVING_ACCOUNT_BY_CLIENT_CODE = "Press [3] To Find A Saving Account By Client Code\n";
    private static final String UPDATE_SAVING_ACCOUNT = "Press [4] To Update A Saving Account";
    private static final String FIND_SAVING_ACCOUNT_BY_OPERATION_NUMBER = "Press [5] To Find A Saving Account By Operation Number\n";
    private static final String DELETE_SAVING_ACCOUNT = "Press [6] To Delete A Saving Account";
    private static final String UPDATE_SAVING_ACCOUNT_STATUS = "Press [7] To Update A Saving Account Status\n";

    public static void show() {
        System.out.println("-----Saving Account Administration-----\n");

        System.out.println(NEW_SAVING_ACCOUNT + ALL_SAVING_ACCOUNTS + FIND_SAVING_ACCOUNT_BY_CLIENT_CODE + UPDATE_SAVING_ACCOUNT+ FIND_SAVING_ACCOUNT_BY_OPERATION_NUMBER + DELETE_SAVING_ACCOUNT + UPDATE_SAVING_ACCOUNT_STATUS);
    }

}
