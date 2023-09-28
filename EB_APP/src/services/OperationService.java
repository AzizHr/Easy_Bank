package services;

import daoImplementaion.OperationDAOImp;
import entities.Operation;

import java.util.Optional;

public class OperationService {

    private static final OperationDAOImp operationDAOImp = new OperationDAOImp();

    public static Optional<Operation> findByNumber(String number) {
        return operationDAOImp.findByNumber(number);
    }

}
