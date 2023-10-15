package services;

import daoImplementaion.EmployeeDAOImp;
import entities.Employee;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeDAOImp employeeDAOImp;

    public EmployeeService(EmployeeDAOImp instance) {
        employeeDAOImp = instance;
    }

    public  Employee save(Employee employee) {

        return employeeDAOImp.save(employee).orElse(null);

    }

    public  boolean delete(String code) {

        return employeeDAOImp.delete(code);
    }

    public  List<Employee> findAll() {

        return employeeDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  Employee findByCode(String code) {

        return employeeDAOImp.findByCode(code).orElse(null);
    }

    public  Employee findByPhoneNumber(String phoneNumber) {

        return employeeDAOImp.findByPhoneNumber(phoneNumber).orElse(null);
    }

    public  boolean update(Employee employee) {

        return employeeDAOImp.update(employee);
    }

}
