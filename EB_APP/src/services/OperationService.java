package services;

import daoImplementaion.OperationDAOImp;
import entities.Client;
import entities.Employee;
import entities.Operation;

import java.util.Optional;

public class OperationService {

    private static OperationDAOImp operationDAOImp;

    public OperationService(OperationDAOImp instance) {
        operationDAOImp = instance;
    }


    public static void saveForCA(Operation operation) {

        System.out.println("New Operation Added With Success!");
        operationDAOImp.saveForCA(operation).ifPresent(System.out::println);
    }

    public static void saveForSA(Operation operation) {

        System.out.println("New Operation Added With Success!");
        operationDAOImp.saveForSA(operation).ifPresent(System.out::println);
    }

    public static void delete(String number) {

        if(operationDAOImp.delete(number)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void findByNumber(String number) {

        Optional<Operation> operationOptional = operationDAOImp.findByNumber(number);

        if (operationOptional.isPresent()) {
            Operation operation = operationOptional.get();
            System.out.println("Operation Found : ");
            System.out.println(operation);
        } else {
            System.out.println("No Operation With This Number Found!");
        }
    }

}
