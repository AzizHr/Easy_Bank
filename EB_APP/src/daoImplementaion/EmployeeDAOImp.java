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

        return Optional.empty();
    }

    /**
     * @param employee 
     * @return
     */
    @Override
    public Optional<Boolean> delete(Employee employee) {
        return Optional.empty();
    }

    /**
     * @param employee 
     * @return
     */
    @Override
    public Optional<Boolean> update(Employee employee) {
        return Optional.empty();
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Employee>> findAll() {
        return Optional.empty();
    }
}
