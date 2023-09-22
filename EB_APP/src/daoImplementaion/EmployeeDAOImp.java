package daoImplementaion;

import dao.IEmployeeDAO;
import database.Database;
import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImp implements IEmployeeDAO<Employee> {

    private static final Connection connection = Database.getInstance().getConnection();
    /**
     * @param code
     * @return
     */
    @Override
    public Optional<Employee> findByCode(String code) {
        return Optional.empty();
    }

    /**
     * @param employee 
     * @return
     */
    @Override
    public Optional<Employee> save(Employee employee) {

        String sql = "INSERT INTO employee (code, first_name, last_name, birth_date, phone_number, email, recruited_at) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getCode());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setObject(4, employee.getBirthDate());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setObject(7, employee.getRecruitedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error when trying to insert");
        }
        return Optional.of(employee);
    }

    /**
     * @param employee
     * @return
     */
    @Override
    public boolean delete(Employee employee) {
        boolean deleted = false;
        String sql = "DELETE FROM employee WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getCode());
            if(preparedStatement.executeUpdate() > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to insert");
        }
        return deleted;
    }

    /**
     * @param employee 
     * @return
     */
    @Override
    public boolean update(Employee employee) {
        return false;
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Employee>> findAll() {
        return Optional.empty();
    }
}
