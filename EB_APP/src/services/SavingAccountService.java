package services;

import daoImplementaion.SavingAccountDAOImp;
import entities.CurrentAccount;
import entities.SavingAccount;
import enums.accountStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SavingAccountService {

    private static final SavingAccountDAOImp savingAccountDAOImp = new SavingAccountDAOImp();

    public static void save(SavingAccount savingAccount) {
        System.out.println("New Current Account Added With Success!");
        savingAccountDAOImp.save(savingAccount).ifPresent(System.out::println);
    }

    public static void findByClient(String code) {

        List<SavingAccount> savingAccounts = savingAccountDAOImp.findByClient(code).orElse(Collections.emptyList());

        if (savingAccounts.isEmpty()) {
            System.out.println("No Saving Accounts Found!");
        } else {
            savingAccounts.forEach(System.out::println);
        }
    }

    public static void delete(String number) {
        if(savingAccountDAOImp.delete(number)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void update(SavingAccount savingAccount) {

        if(savingAccountDAOImp.update(savingAccount)) {
            System.out.println("Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void updateStatus(accountStatus status, String number) {

        if(savingAccountDAOImp.updateStatus(status, number)) {
            System.out.println("Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void findByOperationNumber(String number) {
        Optional<SavingAccount> savingAccountOptional = savingAccountDAOImp.findByOperationNumber(number);

        if (savingAccountOptional.isPresent()) {
            SavingAccount savingAccount = savingAccountOptional.get();
            System.out.println("Saving Account Found : ");
            System.out.println(savingAccount);
        } else {
            System.out.println("No Saving Account With This Operation Number Found!");
        }
    }

    public static void findByNumber(String number) {

        Optional<SavingAccount> savingAccountOptional = savingAccountDAOImp.findByNumber(number);

        if (savingAccountOptional.isPresent()) {
            SavingAccount savingAccount = savingAccountOptional.get();
            System.out.println("Saving Account Found : ");
            System.out.println(savingAccount);
        } else {
            System.out.println("No Saving Account With This Number Found!");
        }
    }

    public static SavingAccount getOne(String number) {

        Optional<SavingAccount> savingAccountOptional = savingAccountDAOImp.findByNumber(number);

        SavingAccount sa = savingAccountOptional.orElse(null);
        return sa;
    }

    public static void findAll() {
        List<SavingAccount> savingAccounts = savingAccountDAOImp.findAll().orElse(Collections.emptyList());

        if (savingAccounts.isEmpty()) {
            System.out.println("No Current Accounts Found!");
        } else {
            savingAccounts.forEach(System.out::println);
        }
    }

    public static void deposit(double balance, String number) {
        if(savingAccountDAOImp.deposit(balance, number)) {
            System.out.println("Balance Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void withdraw(double balance, String number) {
        if(savingAccountDAOImp.withdraw(balance, number)) {
            System.out.println("Balance Updated With Success!");
        } else {
            System.out.println("Error!");
        }
    }
}
