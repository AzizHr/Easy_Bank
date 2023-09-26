package daoImplementaion;

import dao.IOperationDAO;
import database.Database;
import entities.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class OperationDAOImp implements IOperationDAO<Operation> {

    private static final Connection connection = Database.getInstance().getConnection();

    /**
     * @param operation 
     * @return
     */
    @Override
    public Optional<Operation> save(Operation operation) {
        String sql = "INSERT INTO operation (number, created_at, price, payment, employee_code, current_account_number, saving_account_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, operation.getNumber());
            preparedStatement.setObject(2, operation.getCreatedAt());
            preparedStatement.setDouble(3, operation.getPrice());
            preparedStatement.setObject(4, operation.getPayment());
            preparedStatement.setString(5, operation.getEmployee().getCode());
            preparedStatement.setString(6, operation.getAccount().getNumber());
            preparedStatement.setString(7, operation.getAccount().getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(operation);
    }

    /**
     * @param operation 
     * @return
     */
    @Override
    public Optional<Boolean> delete(Operation operation) {
        return Optional.empty();
    }

    /**
     * @param number 
     * @return
     */
    @Override
    public Optional<Operation> findByNumber(String number) {
        return Optional.empty();
    }
}
