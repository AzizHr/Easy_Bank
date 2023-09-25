package services;

import daoImplementaion.CurrentAccountDAOImp;
import entities.CurrentAccount;

import java.util.Optional;

public class CurrentAccountService {

    private static final CurrentAccountDAOImp currentAccountDAOImp = new CurrentAccountDAOImp();
    public static Optional<CurrentAccount> save(CurrentAccount currentAccount) {
        return currentAccountDAOImp.save(currentAccount);
    }

}
