package services;

import daoImplementaion.CurrentAccountDAOImp;
import entities.CurrentAccount;
import entities.Employee;
import enums.accountStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CurrentAccountService {

    private static final CurrentAccountDAOImp currentAccountDAOImp = new CurrentAccountDAOImp();
    public static void save(CurrentAccount currentAccount) {
        System.out.println("New Current Account Added With Success!");
        currentAccountDAOImp.save(currentAccount).ifPresent(System.out::println);
    }

    public static void findByClient(String code) {

        List<CurrentAccount> currentAccounts = currentAccountDAOImp.findAll().orElse(Collections.emptyList());

        if (currentAccounts.isEmpty()) {
            System.out.println("No Current Accounts Found!");
        } else {
            currentAccounts.forEach(System.out::println);
        }
    }

    public static void delete(String number) {
        if(currentAccountDAOImp.delete(number)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void update(CurrentAccount currentAccount) {

        if(currentAccountDAOImp.update(currentAccount)) {
            System.out.println("Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void updateStatus(accountStatus status, String number) {

        if(currentAccountDAOImp.updateStatus(status, number)) {
            System.out.println("Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void findByOperationNumber(String number) {
        Optional<CurrentAccount> currentAccountOptional = currentAccountDAOImp.findByOperationNumber(number);

        if (currentAccountOptional.isPresent()) {
            CurrentAccount currentAccount = currentAccountOptional.get();
            System.out.println("Current Account Found : ");
            System.out.println(currentAccount);
        } else {
            System.out.println("No Current Account With This Operation Number Found!");
        }
    }

    public static void findByNumber(String number) {

        Optional<CurrentAccount> currentAccountOptional = currentAccountDAOImp.findByNumber(number);

        if (currentAccountOptional.isPresent()) {
            CurrentAccount currentAccount = currentAccountOptional.get();
            System.out.println("Current Account Found : ");
            System.out.println(currentAccount);
        } else {
            System.out.println("No Current Account With This Number Found!");
        }
    }

    public static CurrentAccount getOne(String number) {

        Optional<CurrentAccount> currentAccountOptional = currentAccountDAOImp.findByNumber(number);

        return currentAccountOptional.orElse(null);
    }

    public static void findAll() {
        List<CurrentAccount> currentAccounts = currentAccountDAOImp.findAll().orElse(Collections.emptyList());

        if (currentAccounts.isEmpty()) {
            System.out.println("No Current Accounts Found!");
        } else {
            currentAccounts.forEach(System.out::println);
        }
    }

    public static void deposit(double balance, String number) {
        if(currentAccountDAOImp.deposit(balance, number)) {
            System.out.println("Balance Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void withdraw(double balance, String number) {
        if(currentAccountDAOImp.withdraw(balance, number)) {
            System.out.println("Balance Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

}
