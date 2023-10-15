//package helpers;
//
//import controllers.*;
//import daoImplementaion.*;
//import entities.*;
//import enums.accountStatus;
//import enums.paymentType;
//import services.*;
//import validation.Validator;
//
//import java.time.LocalDate;
//import java.util.Scanner;
//
//public class Helper {
//
//    private static final Scanner scanner = new Scanner(System.in);
//    private static final ClientDAOImp clientDAOImp = new ClientDAOImp();
//    private static final ClientService clientService = new ClientService(clientDAOImp);
//    private static final ClientController clientController = new ClientController(clientService);
//    private static final EmployeeDAOImp employeeDAOImp = new EmployeeDAOImp();
//    private static final AgencyDAOImp agencyDAOImp = new AgencyDAOImp();
//    private static final RecruitmentHistoryDAOImp recruitmentHistoryDAOImp = new RecruitmentHistoryDAOImp();
//    private static final EmployeeService employeeService = new EmployeeService(employeeDAOImp);
//    private static final AgencyService agencyService = new AgencyService(agencyDAOImp);
//    private static final RecruitmentHistoryService recruitmentHistoryService = new RecruitmentHistoryService(recruitmentHistoryDAOImp);
//    private static final CurrentAccountDAOImp currentAccountDAOImp = new CurrentAccountDAOImp();
//    private static final CurrentAccountService currentAccountService = new CurrentAccountService(currentAccountDAOImp);
//    private static final CurrentAccountController currentAccountController = new CurrentAccountController(currentAccountService, agencyService, employeeService, clientService);
//    private static final SavingAccountDAOImp savingAccountDAOImp = new SavingAccountDAOImp();
//    private static final SavingAccountService savingAccountService = new SavingAccountService(savingAccountDAOImp);
//    private static final SavingAccountController savingAccountController = new SavingAccountController(savingAccountService, agencyService, employeeService, clientService);
//    private static final EmployeeController employeeController = new EmployeeController(employeeService, agencyService, recruitmentHistoryService);
//    private static final OperationDAOImp operationDAOImp = new OperationDAOImp();
//    private static final OperationService operationService = new OperationService(operationDAOImp);
//    private static final OperationController operationController = new OperationController(operationService, employeeService, currentAccountService, savingAccountService);
//
//    public static void call() {
//
//        int repeatPrincipalMenu;
//
//        do {
//            repeatPrincipalMenu = 0;
//            PrincipalMenu.show();
//            System.out.print("-> ");
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    int repeat;
//                    do {
//                        repeat = 0;
//                        EmployeeMenu.show();
//                        System.out.print("-> ");
//                        int employeeChoice = scanner.nextInt();
//                        switch (employeeChoice) {
//                            case 1:
//                                employeeController.save();
//                                break;
//                            case 2:
//                                employeeController.findAll();
//                                break;
//                            case 3:
//                                employeeController.findByCode();
//                                break;
//                            case 4:
//                                employeeController.update();
//                                break;
//                            case 5:
//                                employeeController.findByPhoneNumber();
//                                break;
//                            case 6:
//                                employeeController.delete();
//                                break;
//                            case 7:
//                                employeeController.assignToAnAgency();
//                                break;
//                            case 8:
//                                employeeController.assignToAnotherAgency();
//                                break;
//                            default:
//                                System.out.println("Not A Valid Option!");
//                        }
//                        System.out.print("Press [1] To Return To The Employee Menu -> ");
//                        repeat = scanner.nextInt();
//                    }while (repeat == 1);
//                    break;
//                case 2:
//                    int repeatClientMenu;
//                    do {
//                        repeatClientMenu = 0;
//                        ClientMenu.show();
//                        System.out.print("-> ");
//                        int clientChoice = scanner.nextInt();
//                        switch (clientChoice) {
//                            case 1:
//                                clientController.save();
//                                break;
//                            case 2:
//                                clientController.findAll();
//                                break;
//                            case 3:
//                                clientController.findByCode();
//                                break;
//                            case 4:
//                                clientController.update();
//                                break;
//                            case 5:
//                                clientController.findByAddress();
//                                break;
//                            case 6:
//                                clientController.delete();
//                                break;
//                            default:
//                                System.out.println("Not A Valid Option!");
//                        }
//                        System.out.print("Press [1] To return To The Client Menu -> ");
//                        repeatClientMenu = scanner.nextInt();
//                    }while (repeatClientMenu == 1);
//                    break;
//                case 3:
//                    System.out.println("Press [1] For Current Account");
//                    System.out.println("Press [2] For Saving Account");
//                    System.out.println("-> ");
//                    int accountChoice = scanner.nextInt();
//                    switch (accountChoice) {
//                        case 1:
//                            int repeatCurrentAccountMenu;
//                            do {
//                                repeatCurrentAccountMenu = 0;
//                                CurrentAccountMenu.show();
//                                int currentAccountChoice = scanner.nextInt();
//                                System.out.println("-> ");
//                                switch (currentAccountChoice) {
//                                    case 1:
//                                        currentAccountController.save();
//                                        break;
//                                    case 2:
//                                        currentAccountController.findAll();
//                                        break;
//                                    case 3:
//                                        currentAccountController.findByClient();
//                                        break;
//                                    case 4:
//                                        currentAccountController.update();
//                                        break;
//                                    case 5:
//                                        // TO DO
//                                        break;
//                                    case 6:
//                                        currentAccountController.delete();
//                                        break;
//                                    case 7:
//                                        currentAccountController.updateStatus();
//                                        break;
//                                    default:
//                                        System.out.println("Invalid Option");
//                                }
//                                System.out.print("Press [1] To Return To The Current Account Menu -> ");
//                                repeatCurrentAccountMenu = scanner.nextInt();
//                            }while (repeatCurrentAccountMenu == 1);
//                            break;
//                        case 2:
//                            int repeatSavingAccountMenu;
//                            do {
//                                repeatSavingAccountMenu = 0;
//                                SavingAccountMenu.show();
//                                int savingAccountChoice = scanner.nextInt();
//                                System.out.println("-> ");
//                                switch (savingAccountChoice) {
//                                    case 1:
//                                        savingAccountController.save();
//                                        break;
//                                    case 2:
//                                        savingAccountController.findAll();
//                                        break;
//                                    case 3:
//                                        savingAccountController.findByClient();
//                                        break;
//                                    case 4:
//                                        savingAccountController.update();
//                                        break;
//                                    case 5:
//                                        // TO DO
//                                        break;
//                                    case 6:
//                                        savingAccountController.delete();
//                                        break;
//                                    case 7:
//                                        savingAccountController.updateStatus();
//                                        break;
//                                    default:
//                                        System.out.println("Invalid Option");
//                                }
//                                System.out.print("Press [1] To Return To The Saving Account Menu -> ");
//                                repeatSavingAccountMenu = scanner.nextInt();
//                            }while (repeatSavingAccountMenu == 1);
//                            break;
//                        default:
//                            System.out.println("Invalid Choice!");
//                    }
//                    break;
//                case 4:
//                    int repeatOperationMenu;
//                    do {
//                        repeatOperationMenu = 0;
//                        OperationMenu.show();
//                        int operationChoice = scanner.nextInt();
//                        System.out.println("-> ");
//                        switch (operationChoice) {
//                            case 1:
//                                System.out.println("Press [1] To Add On A Current Account");
//                                System.out.println("Press [2] To Add On A Saving Account");
//                                System.out.println("-> ");
//                                int option = scanner.nextInt();
//                                switch (option) {
//                                    case 1:
//                                        operationController.saveForCurrentAccount();
//                                        break;
//                                    case 2:
//                                        operationController.saveForSavingAccount();
//                                        break;
//                                    default:
//                                        System.out.println("Invalid Choice!");
//                                }
//                                break;
//                            case 2:
//                                operationController.delete();
//                                break;
//                            case 3:
//                                operationController.findByNumber();
//                        }
//                        System.out.print("Press [1] To Return To The Operation Menu -> ");
//                        repeatOperationMenu = scanner.nextInt();
//                    }while (repeatOperationMenu == 1);
//                    break;
//                case 5:
//                    int repeatMissionMenu;
//                    do {
//                        repeatMissionMenu = 0;
//                        MissionMenu.show();
//                        int missionChoice = scanner.nextInt();
//                        System.out.println("-> ");
//                        switch (missionChoice) {
//                            case 1:
//                                Mission mission = new Mission();
//                                System.out.print("Enter The Mission Code -> ");
//                                String code = scanner.next();
//                                mission.setCode(code);
//                                System.out.print("Enter The Mission Name -> ");
//                                String name = scanner.next();
//                                mission.setName(name);
//                                System.out.print("Enter The Mission Description -> ");
//                                String description = scanner.next();
//                                mission.setDescription(description);
//                                MissionService.save(mission);
//                                break;
//                            case 2:
//                                MissionService.findAll();
//                                break;
//                            case 3:
//                                System.out.print("Enter The Code Of The Mission You Wanna Delete -> ");
//                                String missionCodeToDel = scanner.next();
//                                MissionService.delete(missionCodeToDel);
//                                break;
//                            case 4:
//                                System.out.print("Enter The Mission Code You Wanna Assign -> ");
//                                String missionToAssign = scanner.next();
//                                MissionService.getOne(missionToAssign);
//                                System.out.print("Enter The Employee Code -> ");
//                                String empCode = scanner.next();
//                                EmployeeService.getOne(empCode);
//                                MissionHistory missionHistory = new MissionHistory();
//                                LocalDate startedAt = LocalDate.now();
//                                LocalDate endedAt = startedAt.plusDays(7);
//                                missionHistory.setEmployee(EmployeeService.getOne(empCode));
//                                missionHistory.setMission(MissionService.getOne(missionToAssign));
//                                missionHistory.setStartedAt(startedAt);
//                                missionHistory.setEndedAt(endedAt);
//                                MissionHistoryService.save(missionHistory);
//                                break;
//                            case 5:
//                                System.out.print("Enter The Employee Code -> ");
//                                String empC = scanner.next();
//                                EmployeeService.getOne(empC);
//                                String employeeCode = EmployeeService.getOne(empC).getCode();
//                                System.out.print("Enter The Mission Code -> ");
//                                String missionC = scanner.next();
//                                MissionService.getOne(missionC);
//                                String missionCode = MissionService.getOne(missionC).getCode();
//                                LocalDate sa = LocalDate.now();
//                                MissionHistoryService.delete(employeeCode, missionCode, sa);
//                                break;
//                            default:
//                                System.out.println("Invalid Choice!");
//                        }
//                        System.out.println("Press [1] To Return To The Mission Menu -> ");
//                        repeatMissionMenu = scanner.nextInt();
//                    }while (repeatMissionMenu == 1);
//                    break;
//                default:
//                    PrincipalMenu.show();
//            }
//            System.out.print("Press [1] To Return To The Principal Menu -> ");
//            repeatPrincipalMenu = scanner.nextInt();
//        } while (repeatPrincipalMenu == 1);
//    }
//}