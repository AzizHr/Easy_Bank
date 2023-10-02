package helpers;

public class OperationMenu {

    private static final String NEW_OPERATION = "Press [1] To Add A New Operation\n";
    private static final String FIND_OPERATION_BY_NUMBER = "Press [2] To Find An Operation By Number\n";
    private static final String DELETE_OPERATION = "Press [3] To Delete An Operation\n";

    public static void show() {
        System.out.println("-----Operation Administration-----\n");

        System.out.println(NEW_OPERATION + FIND_OPERATION_BY_NUMBER + DELETE_OPERATION);
    }

}
