package helpers;

import entities.*;
import enums.accountStatus;
import enums.paymentType;
import services.*;
import validation.Validator;

import java.time.LocalDate;
import java.util.Scanner;

public class Helper {

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
                                Employee employee = new Employee();
                                String code;
                                do {
                                    System.out.print("Enter The Employee Code -> ");
                                    code = scanner.next();
                                    employee.setCode(code);
                                }while (!Validator.isString(code));
                                System.out.print("Enter The Employee First Name -> ");
                                String firstName = scanner.next();
                                employee.setFirstName(firstName);
                                System.out.print("Enter The Employee Last Name -> ");
                                String lastName = scanner.next();
                                employee.setLastName(lastName);
                                LocalDate birthDate = LocalDate.of(2001, 2, 2);
                                employee.setBirthDate(birthDate);
                                System.out.print("Enter The Employee Phone Number -> ");
                                String phoneNumber = scanner.next();
                                employee.setPhoneNumber(phoneNumber);
                                System.out.print("Enter The Employee Email -> ");
                                String email = scanner.next();
                                employee.setEmail(email);
                                LocalDate recruitedAt = LocalDate.of(2024, 2, 2);
                                employee.setRecruitedAt(recruitedAt);
                                EmployeeService.save(employee);
                                break;
                            case 2:
                                EmployeeService.findAll();
                                break;
                            case 3:
                                System.out.print("Enter The Code Of The Employee You're Looking For -> ");
                                String empCode = scanner.next();
                                EmployeeService.findByCode(empCode);
                                break;
                            case 4:
                                System.out.print("Enter The Code Of The Employee You Wanna Update -> ");
                                String updateEmpCode = scanner.next();
                                EmployeeService.findByCode(updateEmpCode);
                                System.out.println("Enter The New Information");
                                Employee employeeToUpdate = new Employee();
                                System.out.print("Enter The Employee First Name -> ");
                                String firstNameU = scanner.next();
                                employeeToUpdate.setFirstName(firstNameU);
                                System.out.print("Enter The Employee Last Name -> ");
                                String lastNameU = scanner.next();
                                employeeToUpdate.setLastName(lastNameU);
                                LocalDate birthDateU = LocalDate.of(2001, 2, 2);
                                employeeToUpdate.setBirthDate(birthDateU);
                                System.out.print("Enter The Employee Phone Number -> ");
                                String phoneNumberU = scanner.next();
                                employeeToUpdate.setPhoneNumber(phoneNumberU);
                                System.out.print("Enter The Employee Email -> ");
                                String emailU = scanner.next();
                                employeeToUpdate.setEmail(emailU);
                                LocalDate recruitedAtU = LocalDate.of(2024, 2, 2);
                                employeeToUpdate.setRecruitedAt(recruitedAtU);
                                employeeToUpdate.setCode(updateEmpCode);
                                EmployeeService.update(employeeToUpdate);
                                break;
                            case 5:
                                System.out.print("Enter The Phone Number Of The Employee You're Looking For -> ");
                                String empPhoneNumber = scanner.next();
                                EmployeeService.findByPhoneNumber(empPhoneNumber);
                                break;
                            case 6:
                                System.out.print("Enter The Code Of The Employee You Wanna Delete-> ");
                                String empCodeToDelete = scanner.next();
                                EmployeeService.delete(empCodeToDelete);
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
                                Client client = new Client();
                                System.out.print("Enter The Client Code -> ");
                                String code = scanner.next();
                                client.setCode(code);
                                System.out.print("Enter The Client First Name -> ");
                                String firstName = scanner.next();
                                client.setFirstName(firstName);
                                System.out.print("Enter The Client Last Name -> ");
                                String lastName = scanner.next();
                                client.setLastName(lastName);
                                LocalDate birthDate = LocalDate.of(2001, 2, 2);
                                client.setBirthDate(birthDate);
                                System.out.print("Enter The Client Phone Number -> ");
                                String phoneNumber = scanner.next();
                                client.setPhoneNumber(phoneNumber);
                                System.out.print("Enter The Client Adress -> ");
                                String adress = scanner.next();
                                client.setAdress(adress);
                                ClientService.save(client);
                                break;
                            case 2:
                                ClientService.findAll();
                                break;
                            case 3:
                                System.out.print("Enter The Code Of The Client You're Looking For -> ");
                                String clientCode = scanner.next();
                                ClientService.findByCode(clientCode);
                                break;
                            case 4:
                                System.out.print("Enter The Code Of The Client You Wanna Update -> ");
                                String updateClientCode = scanner.next();
                                ClientService.findByCode(updateClientCode);
                                System.out.println("Enter The New Information");
                                Client clientToUpdate = new Client();
                                System.out.print("Enter The Client First Name -> ");
                                String firstNameU = scanner.next();
                                clientToUpdate.setFirstName(firstNameU);
                                System.out.print("Enter The Client Last Name -> ");
                                String lastNameU = scanner.next();
                                clientToUpdate.setLastName(lastNameU);
                                LocalDate birthDateU = LocalDate.of(2001, 2, 2);
                                clientToUpdate.setBirthDate(birthDateU);
                                System.out.print("Enter The Client Phone Number -> ");
                                String phoneNumberU = scanner.next();
                                clientToUpdate.setPhoneNumber(phoneNumberU);
                                System.out.print("Enter The Client Address -> ");
                                String adressU = scanner.next();
                                clientToUpdate.setAdress(adressU);
                                clientToUpdate.setCode(updateClientCode);
                                ClientService.update(clientToUpdate);
                                break;
                            case 5:
                                System.out.print("Enter The Adress Of The Client You're Looking For -> ");
                                String clientAdress = scanner.next();
                                ClientService.findByAdress(clientAdress);
                                break;
                            case 6:
                                System.out.print("Enter The Code Of The Client You Wanna Delete -> ");
                                String clientCodeToDelete = scanner.next();
                                ClientService.delete(clientCodeToDelete);
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
                                        System.out.println("Enter The Employee Code Who Will Create This Account -> ");
                                        String createdBy = scanner.next();
                                        Employee emp = EmployeeService.getOne(createdBy);
                                        System.out.println("Enter The Client Code Who Will Own This Account -> ");
                                        String createdFor = scanner.next();
                                        Client cli = ClientService.getOne(createdFor);
                                        System.out.println("Now Enter The Current Account Information");
                                        CurrentAccount currentAccount = new CurrentAccount();
                                        System.out.println("Enter The Current Account Number -> ");
                                        String number = scanner.next();
                                        currentAccount.setNumber(number);
                                        System.out.println("Enter The Current Account Balance -> ");
                                        double balance = scanner.nextDouble();
                                        currentAccount.setBalance(balance);
                                        LocalDate createdAt = LocalDate.of(2022, 2, 3);
                                        currentAccount.setCreatedAt(createdAt);
                                        System.out.println("Enter The Current Account Overdraft -> ");
                                        double overdraft = scanner.nextDouble();
                                        currentAccount.setOverdraft(overdraft);
                                        currentAccount.setClient(cli);
                                        currentAccount.setEmployee(emp);
                                        CurrentAccountService.save(currentAccount);
                                        break;
                                    case 2:
                                        CurrentAccountService.findAll();
                                        break;
                                    case 3:
                                        System.out.print("Enter The Client Code -> ");
                                        String cliCode = scanner.next();
                                        CurrentAccountService.findByClient(cliCode);
                                        break;
                                    case 4:
                                        CurrentAccount caToUpdate = new CurrentAccount();
                                        System.out.print("Enter The Number Of The Current Account You Wanna Update -> ");
                                        String caNumber = scanner.next();
                                        CurrentAccountService.findByNumber(caNumber);
                                        System.out.println("Enter The New Information");
                                        System.out.println("Enter The Current Account Balance -> ");
                                        double caBalance = scanner.nextDouble();
                                        caToUpdate.setBalance(caBalance);
                                        System.out.println("Enter The Current Account Overdraft -> ");
                                        double caOverdraft= scanner.nextDouble();
                                        caToUpdate.setOverdraft(caOverdraft);
                                        caToUpdate.setNumber(caNumber);
                                        CurrentAccountService.update(caToUpdate);
                                        break;
                                    case 5:
                                        // TO DO
                                        break;
                                    case 6:
                                        System.out.print("Enter The Number Of The Current Account You Wanna Delete -> ");
                                        String caNumberToDel = scanner.next();
                                        CurrentAccountService.delete(caNumberToDel);
                                        break;
                                    case 7:
                                        System.out.print("Enter The Number Of The Current Account You Wanna Update -> ");
                                        String caNumberToUpSts = scanner.next();
                                        CurrentAccountService.findByNumber(caNumberToUpSts);
                                        System.out.println("Choose The Status");
                                        System.out.println("1- Active");
                                        System.out.println("2- Frozen");
                                        System.out.println("3- Closed");
                                        System.out.print("-> ");
                                        int statusChoice = scanner.nextInt();
                                        switch (statusChoice) {
                                            case 1:
                                                CurrentAccountService.updateStatus(accountStatus.Active, caNumberToUpSts);
                                                break;
                                            case 2:
                                                CurrentAccountService.updateStatus(accountStatus.Frozen, caNumberToUpSts);
                                                break;
                                            case 3:
                                                CurrentAccountService.updateStatus(accountStatus.Closed, caNumberToUpSts);
                                                break;
                                            default:
                                                System.out.println("Invalid Option!");
                                        }
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
                                        System.out.println("Enter The Employee Code Who Will Create This Account -> ");
                                        String createdBy = scanner.next();
                                        Employee emp = EmployeeService.getOne(createdBy);
                                        System.out.println("Enter The Client Code Who Will Own This Account -> ");
                                        String createdFor = scanner.next();
                                        Client cli = ClientService.getOne(createdFor);
                                        System.out.println("Now Enter The Saving Account Information");
                                        SavingAccount savingAccount = new SavingAccount();
                                        System.out.println("Enter The Saving Account Number -> ");
                                        String number = scanner.next();
                                        savingAccount.setNumber(number);
                                        System.out.println("Enter The Saving Account Balance -> ");
                                        double balance = scanner.nextDouble();
                                        savingAccount.setBalance(balance);
                                        LocalDate createdAt = LocalDate.of(2022, 2, 3);
                                        savingAccount.setCreatedAt(createdAt);
                                        System.out.println("Enter The Saving Account Interest -> ");
                                        double overdraft = scanner.nextDouble();
                                        savingAccount.setInterest(overdraft);
                                        savingAccount.setClient(cli);
                                        savingAccount.setEmployee(emp);
                                        SavingAccountService.save(savingAccount);
                                        break;
                                    case 2:
                                        SavingAccountService.findAll();
                                        break;
                                    case 3:
                                        System.out.print("Enter The Client Code -> ");
                                        String cliCode = scanner.next();
                                        SavingAccountService.findByClient(cliCode);
                                        break;
                                    case 4:
                                        SavingAccount saToUpdate = new SavingAccount();
                                        System.out.print("Enter The Number Of The Saving Account You Wanna Update -> ");
                                        String saNumber = scanner.next();
                                        SavingAccountService.findByNumber(saNumber);
                                        System.out.println("Enter The New Information");
                                        System.out.println("Enter The Saving Account Balance -> ");
                                        double saBalance = scanner.nextDouble();
                                        saToUpdate.setBalance(saBalance);
                                        System.out.println("Enter The Saving Account Interest -> ");
                                        double saOverdraft= scanner.nextDouble();
                                        saToUpdate.setInterest(saOverdraft);
                                        saToUpdate.setNumber(saNumber);
                                        SavingAccountService.update(saToUpdate);
                                        break;
                                    case 5:
                                        // TO DO
                                        break;
                                    case 6:
                                        System.out.print("Enter The Number Of The Saving Account You Wanna Delete -> ");
                                        String saNumberToDel = scanner.next();
                                        SavingAccountService.delete(saNumberToDel);
                                        break;
                                    case 7:
                                        System.out.print("Enter The Number Of The Saving Account You Wanna Delete -> ");
                                        String saNumberToUpSts = scanner.next();
                                        SavingAccountService.findByNumber(saNumberToUpSts);
                                        System.out.println("Choose The Status");
                                        System.out.println("1- Active");
                                        System.out.println("2- Frozen");
                                        System.out.println("3- Closed");
                                        System.out.print("-> ");
                                        int statusChoice = scanner.nextInt();
                                        switch (statusChoice) {
                                            case 1:
                                                SavingAccountService.updateStatus(accountStatus.Active, saNumberToUpSts);
                                                break;
                                            case 2:
                                                SavingAccountService.updateStatus(accountStatus.Frozen, saNumberToUpSts);
                                                break;
                                            case 3:
                                                SavingAccountService.updateStatus(accountStatus.Closed, saNumberToUpSts);
                                                break;
                                            default:
                                                System.out.println("Invalid Option!");
                                        }
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
                                        System.out.print("Enter The Employee Code Who Will Do This Operation -> ");
                                        String empCode = scanner.next();
                                        EmployeeService.getOne(empCode);
                                        System.out.print("Enter The Current Account Number -> ");
                                        String caNumber = scanner.next();
                                        CurrentAccountService.getOne(caNumber);
                                        Operation operation = new Operation();
                                        System.out.print("Enter The Operation Number -> ");
                                        String number = scanner.next();
                                        operation.setNumber(number);
                                        LocalDate createdAt = LocalDate.now();
                                        operation.setCreatedAt(createdAt);
                                        System.out.print("Enter The Price -> ");
                                        double price = scanner.nextDouble();
                                        operation.setPrice(price);
                                        System.out.println("Choose The Payment type");
                                        System.out.println("1- Deposit");
                                        System.out.println("2- Withdrawal");
                                        System.out.print("-> ");
                                        int paymentTypeChoice = scanner.nextInt();
                                        switch (paymentTypeChoice) {
                                            case 1:
                                                operation.setPayment(paymentType.Deposit);
                                                CurrentAccountService.deposit(price, caNumber);
                                                break;
                                            case 2:
                                                operation.setPayment(paymentType.Withdrawal);
                                                CurrentAccountService.withdraw(price, caNumber);
                                                break;
                                            default:
                                        }
                                        operation.setEmployee(EmployeeService.getOne(empCode));
                                        operation.setAccount(CurrentAccountService.getOne(caNumber));
                                        OperationService.saveForCA(operation);
                                        break;
                                    case 2:
                                        System.out.print("Enter The Employee Code Who Will Do This Operation -> ");
                                        String eCode = scanner.next();
                                        EmployeeService.getOne(eCode);
                                        System.out.print("Enter The Saving Account Number -> ");
                                        String saNumber = scanner.next();
                                        SavingAccountService.getOne(saNumber);
                                        Operation operation1 = new Operation();
                                        System.out.print("Enter The Operation Number -> ");
                                        String number1 = scanner.next();
                                        operation1.setNumber(number1);
                                        LocalDate createdAt1 = LocalDate.now();
                                        operation1.setCreatedAt(createdAt1);
                                        System.out.print("Enter The Price -> ");
                                        double price1 = scanner.nextDouble();
                                        operation1.setPrice(price1);
                                        System.out.println("Choose The Payment type");
                                        System.out.println("1- Deposit");
                                        System.out.println("2- Withdrawal");
                                        System.out.print("-> ");
                                        int paymentTypeChoice1 = scanner.nextInt();
                                        switch (paymentTypeChoice1) {
                                            case 1:
                                                operation1.setPayment(paymentType.Deposit);
                                                SavingAccountService.deposit(price1, saNumber);
                                                break;
                                            case 2:
                                                operation1.setPayment(paymentType.Withdrawal);
                                                SavingAccountService.withdraw(price1, saNumber);
                                                break;
                                            default:
                                        }
                                        operation1.setEmployee(EmployeeService.getOne(eCode));
                                        operation1.setAccount(SavingAccountService.getOne(saNumber));
                                        OperationService.saveForSA(operation1);
                                        break;
                                    default:
                                        System.out.println("Invalid Choice!");
                                }
                                break;
                            case 2:
                                System.out.print("Enter The Number Of The Operation You Wanna Delete -> ");
                                String opNumberToDel = scanner.next();
                                OperationService.delete(opNumberToDel);
                                break;
                            case 3:
                                System.out.print("Enter The Number Of The Operation You're Looking For -> ");
                                String opNumber = scanner.next();
                                OperationService.findByNumber(opNumber);
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
                                Mission mission = new Mission();
                                System.out.print("Enter The Mission Code -> ");
                                String code = scanner.next();
                                mission.setCode(code);
                                System.out.print("Enter The Mission Name -> ");
                                String name = scanner.next();
                                mission.setName(name);
                                System.out.print("Enter The Mission Description -> ");
                                String description = scanner.next();
                                mission.setDescription(description);
                                MissionService.save(mission);
                                break;
                            case 2:
                                MissionService.findAll();
                                break;
                            case 3:
                                System.out.print("Enter The Code Of The Mission You Wanna Delete -> ");
                                String missionCodeToDel = scanner.next();
                                MissionService.delete(missionCodeToDel);
                                break;
                            case 4:
                                System.out.print("Enter The Mission Code You Wanna Assign -> ");
                                String missionToAssign = scanner.next();
                                MissionService.getOne(missionToAssign);
                                System.out.print("Enter The Employee Code -> ");
                                String empCode = scanner.next();
                                EmployeeService.getOne(empCode);
                                MissionHistory missionHistory = new MissionHistory();
                                LocalDate startedAt = LocalDate.now();
                                LocalDate endedAt = startedAt.plusDays(7);
                                missionHistory.setEmployee(EmployeeService.getOne(empCode));
                                missionHistory.setMission(MissionService.getOne(missionToAssign));
                                missionHistory.setStartedAt(startedAt);
                                missionHistory.setEndedAt(endedAt);
                                MissionHistoryService.save(missionHistory);
                                break;
                            case 5:
                                System.out.print("Enter The Employee Code -> ");
                                String empC = scanner.next();
                                EmployeeService.getOne(empC);
                                String employeeCode = EmployeeService.getOne(empC).getCode();
                                System.out.print("Enter The Mission Code -> ");
                                String missionC = scanner.next();
                                MissionService.getOne(missionC);
                                String missionCode = MissionService.getOne(missionC).getCode();
                                LocalDate sa = LocalDate.now();
                                MissionHistoryService.delete(employeeCode, missionCode, sa);
                                break;
                            default:
                                System.out.println("Invalid Choice!");
                        }
                        System.out.println("Press [1] To Return To The Mission Menu -> ");
                        repeatMissionMenu = scanner.nextInt();
                    }while (repeatMissionMenu == 1);
                    break;
                default:
                    PrincipalMenu.show();
            }
            System.out.print("Press [1] To Return To The Principal Menu -> ");
            repeatPrincipalMenu = scanner.nextInt();
        } while (repeatPrincipalMenu == 1);
    }
}