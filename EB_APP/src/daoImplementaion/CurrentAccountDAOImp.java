package daoImplementaion;

import dao.ICurrentAccountDAO;
import database.Database;
import entities.Client;
import entities.CurrentAccount;
import entities.Employee;
import entities.Person;
import enums.accountStatus;

import java.sql.*;
import java.util.ArrayList;
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
            preparedStatement.setDouble(2, currentAccount.getBalance());
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
     * @param number 
     * @return
     */
    @Override
    public boolean delete(String number) {
        boolean deleted = false;
        String sql = "DELETE FROM current_account WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to delete");
        }
        return deleted;
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
     * @param code
     * @return
     */
    @Override
    public Optional<List<CurrentAccount>> findByClient(String code) {
        List<CurrentAccount> currentAccounts = new ArrayList<>();

        String sql = "SELECT * FROM current_account WHERE client_code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setNumber(rs.getString(1));
                currentAccount.setBalance(rs.getDouble(2));
                currentAccount.setCreatedAt(rs.getDate(3).toLocalDate());
                currentAccount.setStatus((accountStatus) rs.getObject(4));
                currentAccount.setOverdraft(rs.getDouble(5));
                currentAccounts.add(currentAccount);
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to select");
        }
        return Optional.of(currentAccounts);
    }
}
