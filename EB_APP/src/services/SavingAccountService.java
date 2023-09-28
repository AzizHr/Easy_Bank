package services;

import daoImplementaion.SavingAccountDAOImp;
import entities.CurrentAccount;
import entities.SavingAccount;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;

public class SavingAccountService {

    private static final SavingAccountDAOImp savingAccountDAOImp = new SavingAccountDAOImp();

    public static Optional<SavingAccount> save(SavingAccount savingAccount) {
        return savingAccountDAOImp.save(savingAccount);
    }

    public static Optional<List<SavingAccount>> findByClient(String code) {
        return savingAccountDAOImp.findByClient(code);
    }
    public static boolean delete(String number) {
        return savingAccountDAOImp.delete(number);
    }

    public static boolean updateStatus(accountStatus status, String number) {
        return savingAccountDAOImp.updateStatus(status, number);
    }

    public static Optional<List<SavingAccount>> findAll() {
        return savingAccountDAOImp.findAll();
    }


}
