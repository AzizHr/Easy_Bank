package daoImplementaion;

import dao.ISavingAccountDAO;
import entities.Person;
import entities.SavingAccount;
import enums.accountStatus;
import java.util.List;
import java.util.Optional;

public class SavingAccountDAOImp implements ISavingAccountDAO<SavingAccount> {
    /**
     * @param savingAccount 
     * @return
     */
    @Override
    public Optional<SavingAccount> save(SavingAccount savingAccount) {
        return Optional.empty();
    }

    /**
     * @param savingAccount 
     * @return
     */
    @Override
    public Optional<Boolean> delete(SavingAccount savingAccount) {
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
    public Optional<List<SavingAccount>> findAll() {
        return Optional.empty();
    }

    /**
     * @param code
     * @return
     */
    @Override
    public Optional<List<SavingAccount>> findByClient(String code) {
        return Optional.empty();
    }
}
