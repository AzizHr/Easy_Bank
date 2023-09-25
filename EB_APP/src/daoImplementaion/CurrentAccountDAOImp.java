package daoImplementaion;

import dao.ICurrentAccountDAO;
import database.Database;
import entities.CurrentAccount;
import entities.Person;
import enums.accountStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

public class CurrentAccountDAOImp implements ICurrentAccountDAO<CurrentAccount> {

    private static final Connection connection = Database.getInstance().getConnection();
    /**
     * @param currentAccount 
     * @return
     */
    @Override
    public Optional<CurrentAccount> save(CurrentAccount currentAccount) {

        String sql = "INSERT INTO current_account (number, balance, created_at, status, overdraft, client_code, employee_code) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, currentAccount.getNumber());
            preparedStatement.setFloat(2, currentAccount.getBalance());
            preparedStatement.setObject(3, currentAccount.getCreatedAt());
            preparedStatement.setObject(4, currentAccount.getStatus());
            preparedStatement.setObject(5, currentAccount.getOverdraft());
            preparedStatement.setString(6, currentAccount.getClient().getCode());
            preparedStatement.setString(7, currentAccount.getEmployee().getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(currentAccount);
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
