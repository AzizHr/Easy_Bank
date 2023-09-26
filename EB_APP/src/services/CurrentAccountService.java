package services;

import daoImplementaion.CurrentAccountDAOImp;
import entities.CurrentAccount;

import java.util.List;
import java.util.Optional;

public class CurrentAccountService {

    private static final CurrentAccountDAOImp currentAccountDAOImp = new CurrentAccountDAOImp();
    public static Optional<CurrentAccount> save(CurrentAccount currentAccount) {
        return currentAccountDAOImp.save(currentAccount);
    }

    public static Optional<List<CurrentAccount>> findByClient(String code) {
        return currentAccountDAOImp.findByClient(code);
    }

    public static boolean delete(String number) {
        return currentAccountDAOImp.delete(number);
    }

}
