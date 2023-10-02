package services;

import daoImplementaion.CurrentAccountDAOImp;
import entities.CurrentAccount;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static boolean update(CurrentAccount currentAccount) {
        return currentAccountDAOImp.update(currentAccount);
    }

    public static Optional<CurrentAccount> findByOperationNumber(String number) {
        return currentAccountDAOImp.findByOperationNumber(number);
    }
  
    public static boolean updateStatus(accountStatus status, String number) {
        return currentAccountDAOImp.updateStatus(status, number);
    }

    public static Optional<List<CurrentAccount>> findAll() {
        return currentAccountDAOImp.findAll();
    }

}
