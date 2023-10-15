package services;

import daoImplementaion.SavingAccountDAOImp;
import entities.SavingAccount;
import enums.accountStatus;
import java.util.Collections;
import java.util.List;

public class SavingAccountService {

    private final SavingAccountDAOImp savingAccountDAOImp;

    public SavingAccountService(SavingAccountDAOImp instance){
        savingAccountDAOImp = instance;
    }


    public SavingAccount save(SavingAccount SavingAccount) {

        return savingAccountDAOImp.save(SavingAccount).orElse(null);

    }

    public  boolean delete(String number) {

        return savingAccountDAOImp.delete(number);
    }

    public  List<SavingAccount> findAll() {

        return savingAccountDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  SavingAccount findByNumber(String number) {

        return savingAccountDAOImp.findByNumber(number).orElse(null);
    }

    public  List<SavingAccount> findByClient(String clientCode) {

        return savingAccountDAOImp.findByClient(clientCode).orElse(null);
    }

    public  SavingAccount findByOperationNumber(String operationNumber) {

        return savingAccountDAOImp.findByOperationNumber(operationNumber).orElse(null);
    }


    public  boolean update(SavingAccount SavingAccount) {

        return savingAccountDAOImp.update(SavingAccount);
    }

    public  boolean updateStatus(accountStatus status, String number) {

        return savingAccountDAOImp.updateStatus(status, number);
    }

    public  boolean deposit(double balance, String number) {

        return savingAccountDAOImp.deposit(balance, number);

    }

    public  boolean withdraw(double balance, String number) {

        return savingAccountDAOImp.withdraw(balance, number);

    }
}
