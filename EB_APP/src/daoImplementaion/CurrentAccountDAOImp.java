package daoImplementaion;

import dao.ICurrentAccountDAO;
import entities.CurrentAccount;
import entities.Person;
import enums.accountStatus;

import java.util.List;
import java.util.Optional;

public class CurrentAccountDAOImp implements ICurrentAccountDAO<CurrentAccount> {
    /**
     * @param currentAccount 
     * @return
     */
    @Override
    public Optional<CurrentAccount> save(CurrentAccount currentAccount) {
        return Optional.empty();
    }

    /**
     * @param currentAccount 
     * @return
     */
    @Override
    public Optional<Boolean> delete(CurrentAccount currentAccount) {
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
    public Optional<List<CurrentAccount>> findAll() {
        return Optional.empty();
    }

    /**
     * @param person 
     * @return
     */
    @Override
    public Optional<List<CurrentAccount>> findByClient(Person person) {
        return Optional.empty();
    }
}
