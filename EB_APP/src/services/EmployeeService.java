package services;

import daoImplementaion.EmployeeDAOImp;
import entities.Employee;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private  EmployeeDAOImp employeeDAOImp;

    public EmployeeService(EmployeeDAOImp instance) {
        employeeDAOImp = instance;
    }

    public  Employee save(Employee employee) {

        try {
            Optional<Employee> employeeOptional = employeeDAOImp.save(employee);

            if (employeeOptional.isPresent()) {
                return employeeOptional.get();
            } else {
                throw new Exception("Error When Trying To Insert!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public  boolean delete(String code) {

        try {
            if(employeeDAOImp.delete(code)) {
                return true;
            } else {
                throw new Exception("Error When Trying To Delete!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Employee> findAll() {

        try {
            List<Employee> employees = employeeDAOImp.findAll().orElse(Collections.emptyList());

            if (employees.isEmpty()) {
                throw new Exception("No Employees Found!");
            } else {
                return employees;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  Employee findByCode(String code) {

        try {

            Optional<Employee> employeeOptional = employeeDAOImp.findByCode(code);

            if (employeeOptional.isPresent()) {
                return employeeOptional.get();
            } else {
                throw new Exception("No Employee With This Code Found!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  Employee findByPhoneNumber(String phoneNumber) {

        try {

            Optional<Employee> employeeOptional = employeeDAOImp.findByPhoneNumber(phoneNumber);

            if (employeeOptional.isPresent()) {
                return employeeOptional.get();
            } else {
                throw new Exception("No Employee With This Adress Found!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  boolean update(Employee employee) {

        try {
            if(employeeDAOImp.update(employee)) {
                return true;
            } else {
                throw new Exception("Error When Trying To Update!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}
  
    public static Optional<List<Employee>> findAll() {
        return employeeDAOImp.findAll();
    }

    public static Optional<Employee> findByPhoneNumber(String phoneNumber) {
        return employeeDAOImp.findByPhoneNumber(phoneNumber);
    }

}
