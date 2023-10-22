package helpers;

import controllers.*;
import daoImplementaion.*;
import services.*;
import java.util.Scanner;

public class Helper {

    private static final AgencyController agencyController = new AgencyController(new AgencyService(new AgencyDAOImp()));
    private static final EmployeeController employeeController = new EmployeeController(new EmployeeService(new EmployeeDAOImp()), new AgencyService(new AgencyDAOImp()), new RecruitmentHistoryService(new RecruitmentHistoryDAOImp()));
    private static final ClientController clientController = new ClientController(new ClientService(new ClientDAOImp()), new EmployeeService(new EmployeeDAOImp()));
    private static final CurrentAccountController currentAccountController = new CurrentAccountController(new CurrentAccountService(new CurrentAccountDAOImp()), new AgencyService(new AgencyDAOImp()), new EmployeeService(new EmployeeDAOImp()), new ClientService(new ClientDAOImp()));
    private static final SavingAccountController savingAccountController = new SavingAccountController(new SavingAccountService(new SavingAccountDAOImp()), new AgencyService(new AgencyDAOImp()), new EmployeeService(new EmployeeDAOImp()), new ClientService(new ClientDAOImp()));
    private static final OperationController operationController = new OperationController(new OperationService(new OperationDAOImp()), new EmployeeService(new EmployeeDAOImp()), new CurrentAccountService(new CurrentAccountDAOImp()), new SavingAccountService(new SavingAccountDAOImp()));
    private static final MissionController missionController = new MissionController(new MissionService(new MissionDAOImp()), new EmployeeService(new EmployeeDAOImp()), new MissionHistoryService(new MissionHistoryDAOImp()));
    private static final DemandController demandController = new DemandController(new DemandService(new DemandDAOImp()), new AgencyService(new AgencyDAOImp()), new ClientService(new ClientDAOImp()));
    private static final PaymentController paymentController = new PaymentController(new PaymentService(new PaymentDAOImp()), new EmployeeService(new EmployeeDAOImp()), new CurrentAccountService(new CurrentAccountDAOImp()), new SavingAccountService(new SavingAccountDAOImp()));
    private static final Scanner scanner = new Scanner(System.in);


    public static void call() {

        int repeatPrincipalMenu;

        do {
            repeatPrincipalMenu = 0;
            PrincipalMenu.show();
            System.out.print("-> ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int repeat;
                    do {
                        repeat = 0;
                        EmployeeMenu.show();
                        System.out.print("-> ");
                        int employeeChoice = scanner.nextInt();
                        switch (employeeChoice) {
                            case 1:
                                employeeController.save();
                                break;
                            case 2:
                                employeeController.findAll();
                                break;
                            case 3:
                                employeeController.findByCode();
                                break;
                            case 4:
                                employeeController.update();
                                break;
                            case 5:
                                employeeController.findByPhoneNumber();
                                break;
                            case 6:
                                employeeController.delete();
                                break;
                            case 7:
                                employeeController.assignToAnAgency();
                                break;
                            case 8:
                                employeeController.assignToAnotherAgency();
                                break;
                            default:
                                System.out.println("Not A Valid Option!");
                        }
                        System.out.print("Press [1] To Return To The Employee Menu -> ");
                        repeat = scanner.nextInt();
                    }while (repeat == 1);
                    break;
                case 2:
                    int repeatClientMenu;
                    do {
                        repeatClientMenu = 0;
                        ClientMenu.show();
                        System.out.print("-> ");
                        int clientChoice = scanner.nextInt();
                        switch (clientChoice) {
                            case 1:
                                clientController.save();
                                break;
                            case 2:
                                clientController.findAll();
                                break;
                            case 3:
                                clientController.findByCode();
                                break;
                            case 4:
                                clientController.update();
                                break;
                            case 5:
                                clientController.findByAddress();
                                break;
                            case 6:
                                clientController.delete();
                                break;
                            default:
                                System.out.println("Not A Valid Option!");
                        }
                        System.out.print("Press [1] To return To The Client Menu -> ");
                        repeatClientMenu = scanner.nextInt();
                    }while (repeatClientMenu == 1);
                    break;
                case 3:
                    System.out.println("Press [1] For Current Account");
                    System.out.println("Press [2] For Saving Account");
                    System.out.println("-> ");
                    int accountChoice = scanner.nextInt();
                    switch (accountChoice) {
                        case 1:
                            int repeatCurrentAccountMenu;
                            do {
                                repeatCurrentAccountMenu = 0;
                                CurrentAccountMenu.show();
                                int currentAccountChoice = scanner.nextInt();
                                System.out.println("-> ");
                                switch (currentAccountChoice) {
                                    case 1:
                                        currentAccountController.save();
                                        break;
                                    case 2:
                                        currentAccountController.findAll();
                                        break;
                                    case 3:
                                        currentAccountController.findByClient();
                                        break;
                                    case 4:
                                        currentAccountController.update();
                                        break;
                                    case 5:
                                        // TO DO
                                        break;
                                    case 6:
                                        currentAccountController.delete();
                                        break;
                                    case 7:
                                        currentAccountController.updateStatus();
                                        break;
                                    default:
                                        System.out.println("Invalid Option");
                                }
                                System.out.print("Press [1] To Return To The Current Account Menu -> ");
                                repeatCurrentAccountMenu = scanner.nextInt();
                            }while (repeatCurrentAccountMenu == 1);
                            break;
                        case 2:
                            int repeatSavingAccountMenu;
                            do {
                                repeatSavingAccountMenu = 0;
                                SavingAccountMenu.show();
                                int savingAccountChoice = scanner.nextInt();
                                System.out.println("-> ");
                                switch (savingAccountChoice) {
                                    case 1:
                                        savingAccountController.save();
                                        break;
                                    case 2:
                                        savingAccountController.findAll();
                                        break;
                                    case 3:
                                        savingAccountController.findByClient();
                                        break;
                                    case 4:
                                        savingAccountController.update();
                                        break;
                                    case 5:
                                        // TO DO
                                        break;
                                    case 6:
                                        savingAccountController.delete();
                                        break;
                                    case 7:
                                        savingAccountController.updateStatus();
                                        break;
                                    default:
                                        System.out.println("Invalid Option");
                                }
                                System.out.print("Press [1] To Return To The Saving Account Menu -> ");
                                repeatSavingAccountMenu = scanner.nextInt();
                            }while (repeatSavingAccountMenu == 1);
                            break;
                        default:
                            System.out.println("Invalid Choice!");
                    }
                    break;
                case 4:
                    int repeatOperationMenu;
                    do {
                        repeatOperationMenu = 0;
                        OperationMenu.show();
                        int operationChoice = scanner.nextInt();
                        System.out.println("-> ");
                        switch (operationChoice) {
                            case 1:
                                System.out.println("Press [1] To Add On A Current Account");
                                System.out.println("Press [2] To Add On A Saving Account");
                                System.out.println("-> ");
                                int option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        operationController.saveForCurrentAccount();
                                        break;
                                    case 2:
                                        operationController.saveForSavingAccount();
                                        break;
                                    default:
                                        System.out.println("Invalid Choice!");
                                }
                                break;
                            case 2:
                                operationController.delete();
                                break;
                            case 3:
                                operationController.findByNumber();
                        }
                        System.out.print("Press [1] To Return To The Operation Menu -> ");
                        repeatOperationMenu = scanner.nextInt();
                    }while (repeatOperationMenu == 1);
                    break;
                case 5:
                    int repeatMissionMenu;
                    do {
                        repeatMissionMenu = 0;
                        MissionMenu.show();
                        int missionChoice = scanner.nextInt();
                        System.out.println("-> ");
                        switch (missionChoice) {
                            case 1:
                                missionController.save();
                                break;
                            case 2:
                                missionController.findAll();
                                break;
                            case 3:
                                missionController.delete();
                                break;
                            case 4:
                                missionController.assignToAnEmployee();
                                break;
                            case 5:
                                missionController.deleteAnAssignment();
                                break;
                            default:
                                System.out.println("Invalid Choice!");
                        }
                        System.out.println("Press [1] To Return To The Mission Menu -> ");
                        repeatMissionMenu = scanner.nextInt();
                    }while (repeatMissionMenu == 1);
                    break;
                case 6:
                    int repeatAgencyMenu;
                    do {
                        repeatAgencyMenu = 0;
                        AgencyMenu.show();
                        int agencyChoice = scanner.nextInt();
                        System.out.println("-> ");
                        switch (agencyChoice) {
                            case 1:
                                agencyController.save();
                                break;
                            case 2:
                                agencyController.findAll();
                                break;
                            case 3:
                                agencyController.findByCode();
                                break;
                            case 4:
                                agencyController.update();
                                break;
                            case 5:
                                agencyController.findByAddress();
                                break;
                            case 6:
//                                agencyController.findByEmployee();
                                break;
                            case 7:
                                agencyController.delete();
                                break;
                            default:
                                System.out.println("Invalid Choice!");
                        }
                        System.out.println("Press [1] To Return To The Agency Menu -> ");
                        repeatAgencyMenu = scanner.nextInt();
                    }while (repeatAgencyMenu == 1);
                    break;
                case 7:
                    int repeatDemandMenu;
                    do {
                        repeatDemandMenu = 0;
                        DemandMenu.show();
                        int demandChoice = scanner.nextInt();
                        System.out.println("-> ");
                        switch (demandChoice) {
                            case 1:
                                demandController.save();
                                break;
                            case 2:
                                demandController.findAll();
                                break;
                            case 3:
                                demandController.findByNumber();
                                break;
                            case 4:
                                demandController.updateStatus();
                                break;
                            case 5:
                                demandController.delete();
                                break;
                            default:
                                System.out.println("Invalid Choice!");
                        }
                        System.out.println("Press [1] To Return To The Demand Menu -> ");
                        repeatDemandMenu = scanner.nextInt();
                    }while (repeatDemandMenu == 1);
                    break;
                case 8:
                    int repeatPaymentMenu;
                    do {
                        repeatPaymentMenu = 0;
                        PaymentMenu.show();
                        int paymentChoice = scanner.nextInt();
                        System.out.println("-> ");
                        switch (paymentChoice) {
                            case 1:
                                System.out.println("Press [1] To Add On A Current Account");
                                System.out.println("Press [2] To Add On A Saving Account");
                                System.out.println("-> ");
                                int option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        paymentController.saveForCurrentAccount();
                                        break;
                                    case 2:
                                        paymentController.saveForSavingAccount();
                                        break;
                                    default:
                                        System.out.println("Invalid Choice!");
                                }
                                break;
                            case 2:
                                paymentController.findByNumber();
                                break;
                            case 3:
                                paymentController.delete();
                        }
                        System.out.print("Press [1] To Return To The Payment Menu -> ");
                        repeatPaymentMenu = scanner.nextInt();
                    }while (repeatPaymentMenu == 1);
                    break;
                default:
                    PrincipalMenu.show();
            }
            System.out.print("Press [1] To Return To The Principal Menu -> ");
            repeatPrincipalMenu = scanner.nextInt();
        } while (repeatPrincipalMenu == 1);
    }
}