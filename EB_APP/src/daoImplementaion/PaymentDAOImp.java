package daoImplementaion;

import dao.IPaymentDAO;
import database.Database;
import entities.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;

public class PaymentDAOImp implements IPaymentDAO<Payment> {

    private static final Connection connection = Database.getInstance().getConnection();


    /**
     * @param payment 
     * @return
     */
    @Override
    public Optional<Payment> saveForCA(Payment payment) {
        String sql = "INSERT INTO payment (number, created_at, price, payment, employee_code, source_current_account_number, destination_current_account_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, payment.getNumber());
            preparedStatement.setObject(2, payment.getCreatedAt());
            preparedStatement.setDouble(3, payment.getPrice());
            preparedStatement.setObject(4, payment.getPayment(), Types.OTHER);
            preparedStatement.setString(5, payment.getEmployee().getCode());
            preparedStatement.setString(6, payment.getAccount().getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(payment);
    }

    /**
     * @param payment 
     * @return
     */
    @Override
    public Optional<Payment> saveForSA(Payment payment) {
        String sql = "INSERT INTO operation (number, created_at, price, payment, employee_code, source_saving_account_number, destination_saving_account_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, payment.getNumber());
            preparedStatement.setObject(2, payment.getCreatedAt());
            preparedStatement.setDouble(3, payment.getPrice());
            preparedStatement.setObject(4, payment.getPayment(), Types.OTHER);
            preparedStatement.setString(5, payment.getEmployee().getCode());
            preparedStatement.setString(6, payment.getAccount().getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(payment);
    }

    /**
     * @param number 
     * @return
     */
    @Override
    public boolean delete(String number) {
        boolean deleted = false;
        String sql = "DELETE FROM payment WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to delete");
        }
        return deleted;
    }
}
