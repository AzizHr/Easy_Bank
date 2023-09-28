package services;

import daoImplementaion.EmployeeDAOImp;
import entities.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private static final EmployeeDAOImp employeeDAOImp = new EmployeeDAOImp();

    public static Optional<Employee> save(Employee employee) {

        return employeeDAOImp.save(employee);

    }

    public static boolean delete(Employee employee) {

        return employeeDAOImp.delete(employee);

    }

    public static Optional<Employee> findByCode(String code) {

        return employeeDAOImp.findByCode(code);

    }

    public static Optional<List<Employee>> findAll() {
        // get all
        return employeeDAOImp.findAll();
    }

}
