package services;

import daoImplementaion.CurrentAccountDAOImp;
import entities.CurrentAccount;
import enums.accountStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CurrentAccountService {

    private  CurrentAccountDAOImp currentAccountDAOImp;

    public CurrentAccountService(CurrentAccountDAOImp instance) {
        currentAccountDAOImp = instance;
    }

    public  CurrentAccount save(CurrentAccount currentAccount) {

        return currentAccountDAOImp.save(currentAccount).orElse(null);

    }

    public  boolean delete(String number) {

        return currentAccountDAOImp.delete(number);
    }

    public  List<CurrentAccount> findAll() {

        return currentAccountDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  CurrentAccount findByNumber(String number) {

        return currentAccountDAOImp.findByNumber(number).orElse(null);
    }

    public  List<CurrentAccount> findByClient(String clientCode) {

        return currentAccountDAOImp.findByClient(clientCode).orElse(null);
    }

    public  CurrentAccount findByOperationNumber(String operationNumber) {

        return currentAccountDAOImp.findByOperationNumber(operationNumber).orElse(null);
    }


    public  boolean update(CurrentAccount currentAccount) {

        return currentAccountDAOImp.update(currentAccount);
    }

    public  boolean updateStatus(accountStatus status, String number) {

        return currentAccountDAOImp.updateStatus(status, number);
    }

    public  boolean deposit(double balance, String number) {

        return currentAccountDAOImp.deposit(balance, number);

    }

    public  boolean withdraw(double balance, String number) {

        return currentAccountDAOImp.withdraw(balance, number);

    }

}
