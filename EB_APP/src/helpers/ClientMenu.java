package helpers;

public class ClientMenu {

    private static final String NEW_CLIENT = "Press [1] To Add A New Client\n";
    private static final String ALL_CLIENTS = "Press [2] To Show All Clients\n";
    private static final String FIND_CLIENT_BY_CODE = "Press [3] To Find An Client By Code\n";
    private static final String UPDATE_CLIENT = "Press [4] To Update An Client\n";
    private static final String FIND_CLIENT_BY_ADRESS = "Press [5] To Find An Client By Adress\n";
    private static final String DELETE_CLIENT = "Press [6] To Delete An Client\n";

    public static void show() {
        System.out.println("-----Client Administration-----\n");

        System.out.println(NEW_CLIENT + ALL_CLIENTS + FIND_CLIENT_BY_CODE + UPDATE_CLIENT + FIND_CLIENT_BY_ADRESS + DELETE_CLIENT);
    }

}
