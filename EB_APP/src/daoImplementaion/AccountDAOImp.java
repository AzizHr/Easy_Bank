package daoImplementaion;

import dao.IAccountDAO;
import entities.Account;
import entities.Person;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;

public class AccountDAOImp implements IAccountDAO<Account> {
    /**
     * @param account 
     * @return
     */
    @Override
    public Optional<Account> save(Account account) {
        return Optional.empty();
    }

    /**
     * @param account 
     * @return
     */
    @Override
    public Optional<Boolean> delete(Account account) {
        return Optional.empty();
    }

    /**
     * @param status 
     * @return
     */
    @Override
    public Optional<Boolean> updateStatus(accountStatus status) {
        return Optional.empty();
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Account>> findAll() {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public Optional<List<Account>> findByClient(String code) {
        return Optional.empty();
    }
}
