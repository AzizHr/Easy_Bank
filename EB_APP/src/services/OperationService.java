package services;

import daoImplementaion.OperationDAOImp;
import entities.Operation;
import java.util.Optional;

public class OperationService {

    private  OperationDAOImp operationDAOImp;

    public OperationService(OperationDAOImp instance) {
        operationDAOImp = instance;
    }


    public  Operation saveForCA(Operation operation) {

        return operationDAOImp.saveForCA(operation).orElse(null);

    }

    public  Operation saveForSA(Operation operation) {

        return operationDAOImp.saveForSA(operation).orElse(null);

    }

    public  boolean delete(String number) {

        return operationDAOImp.delete(number);
    }

    public  Operation findByNumber(String number) {

        return operationDAOImp.findByNumber(number).orElse(null);

    }

}
