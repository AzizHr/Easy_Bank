package daoImplementaion;

import dao.IEmployeeDAO;
import database.Database;
import entities.Employee;

import java.sql.*;
import java.util.ArrayList;
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
        Employee employee = new Employee();
        String sql = "SELECT * FROM employee WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                employee.setCode(rs.getString(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setBirthDate(rs.getDate(4).toLocalDate());
                employee.setPhoneNumber(rs.getString(5));
                employee.setEmail(rs.getString(6));
                employee.setRecruitedAt(rs.getDate(7).toLocalDate());
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to select");
        }
        return Optional.of(employee);
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
            throw new RuntimeException(e);
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
            deleted = preparedStatement.executeUpdate() > 0;
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
    public int update(Employee employee) {
        return 0;
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Employee>> findAll() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Employee employee = new Employee();
                employee.setCode(rs.getString(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setBirthDate(rs.getDate(4).toLocalDate());
                employee.setPhoneNumber(rs.getString(5));
                employee.setEmail(rs.getString(6));
                employee.setRecruitedAt(rs.getDate(6).toLocalDate());
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(employees);
    }
}
