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
}
