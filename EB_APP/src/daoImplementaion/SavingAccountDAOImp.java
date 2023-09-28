package daoImplementaion;

import dao.ISavingAccountDAO;
import database.Database;
import entities.CurrentAccount;
import entities.Person;
import entities.SavingAccount;
import enums.accountStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SavingAccountDAOImp implements ISavingAccountDAO<SavingAccount> {

    private static final Connection connection = Database.getInstance().getConnection();
    private static final ClientDAOImp clientDAOImp = new ClientDAOImp();
    private static final EmployeeDAOImp employeeDAOImp = new EmployeeDAOImp();

    /**
     * @param savingAccount 
     * @return
     */
    @Override
    public Optional<SavingAccount> save(SavingAccount savingAccount) {
        String sql = "INSERT INTO saving_account (number, balance, created_at, status, interest, client_code, employee_code) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, savingAccount.getNumber());
            preparedStatement.setDouble(2, savingAccount.getBalance());
            preparedStatement.setObject(3, savingAccount.getCreatedAt());
            preparedStatement.setObject(4, savingAccount.getStatus());
            preparedStatement.setObject(5, savingAccount.getInterest());
            preparedStatement.setString(6, savingAccount.getClient().getCode());
            preparedStatement.setString(7, savingAccount.getEmployee().getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(savingAccount);
    }

    /**
     * @param number
     * @return
     */
    @Override
    public boolean delete(String number) {
        boolean deleted = false;
        String sql = "DELETE FROM saving_account WHERE number = ?";

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
    public boolean updateStatus(accountStatus status, String number) {
        boolean updated = false;

        String sql = "UPDATE saving_account SET account_status = ? WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, status);
            preparedStatement.setString(2, number);
            updated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return updated;
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<SavingAccount>> findAll() {
        List<SavingAccount> savingAccounts = new ArrayList<>();

        String sql = "SELECT * FROM saving_account";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setNumber(rs.getString(1));
                savingAccount.setBalance(rs.getDouble(2));
                savingAccount.setCreatedAt(rs.getDate(3).toLocalDate());
                savingAccount.setStatus((accountStatus) rs.getObject(4));
                savingAccount.setInterest(rs.getDouble(5));
                savingAccount.setClient(clientDAOImp.findByCode(rs.getString(6)).get());
                savingAccount.setEmployee(employeeDAOImp.findByCode(rs.getString(7)).get());
                savingAccounts.add(savingAccount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(savingAccounts);
    }

    /**
     * @param code
     * @return
     */
    @Override
    public Optional<List<SavingAccount>> findByClient(String code) {

        List<SavingAccount> savingAccounts = new ArrayList<>();

        String sql = "SELECT * FROM saving_account WHERE client_code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setNumber(rs.getString(1));
                savingAccount.setBalance(rs.getDouble(2));
                savingAccount.setCreatedAt(rs.getDate(3).toLocalDate());
                savingAccount.setStatus((accountStatus) rs.getObject(4));
                savingAccount.setInterest(rs.getDouble(5));
                savingAccounts.add(savingAccount);
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to select");
        }
        return Optional.of(savingAccounts);
    }

    /**
     * @param number 
     * @return
     */
    @Override
    public Optional<SavingAccount> findByNumber(String number) {
        return Optional.empty();
    }

    /**
     * @param balance 
     * @param number
     * @return
     */
    @Override
    public boolean deposit(double balance, String number) {
        boolean updated = false;
        String sql = "UPDATE saving_account SET balance = balance + ? WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, number);
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to update");
        }
        return updated;
    }

    /**
     * @param balance 
     * @param number
     * @return
     */
    @Override
    public boolean withdraw(double balance, String number) {
        boolean updated = false;
        String sql = "UPDATE current_account SET balance = balance - ? WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, number);
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to update");
        }
        return updated;
    }
}
