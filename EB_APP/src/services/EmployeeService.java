package services;

import daoImplementaion.EmployeeDAOImp;
import entities.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

    private static EmployeeDAOImp employeeDAOImp;

    public EmployeeService(EmployeeDAOImp instance) {
        employeeDAOImp = instance;
    }

    public static void save(Employee employee) {

        System.out.println("New Employee Added With Success!");
        employeeDAOImp.save(employee).ifPresent(System.out::println);

    }

    public static void delete(String code) {

        if(employeeDAOImp.delete(code)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void findAll() {
        List<Employee> employees = employeeDAOImp.findAll().orElse(Collections.emptyList());

        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
        } else {
            employees.forEach(System.out::println);
        }
    }

    public static void findByCode(String code) {

        Optional<Employee> employeeOptional = employeeDAOImp.findByCode(code);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            System.out.println("Employee Found : ");
            System.out.println(employee);
        } else {
            System.out.println("No Employee With This Code Found!");
        }
    }

    public static Employee getOne(String code) {

        Optional<Employee> employeeOptional = employeeDAOImp.findByCode(code);

        return employeeOptional.orElse(null);
    }

    public static void findByPhoneNumber(String phoneNUmber) {

        Optional<Employee> employeeOptional = employeeDAOImp.findByPhoneNumber(phoneNUmber);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            System.out.println("Employee Found : ");
            System.out.println(employee);
        } else {
            System.out.println("No Employee With This Phone Number Found!");
        }

    }

    public static void update(Employee employee) {

        if(employeeDAOImp.update(employee)) {
            System.out.println("Updated With Success!");
        } else {
            System.out.println("Error!");
        }

    }

}
