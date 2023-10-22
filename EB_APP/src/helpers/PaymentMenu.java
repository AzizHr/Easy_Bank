package helpers;

public class PaymentMenu {

    private static final String NEW_PAYMENT= "Press [1] To Make A New Payment\n";
    private static final String FIND_PAYMENT_BY_NUMBER = "Press [2] To Find A Payment By Number\n";
    private static final String DELETE_PAYMENT = "Press [3] To Delete A Payment\n";

    public static void show() {
        System.out.println("-----Payment Administration-----\n");

        System.out.println(NEW_PAYMENT + FIND_PAYMENT_BY_NUMBER + DELETE_PAYMENT);
    }

}

