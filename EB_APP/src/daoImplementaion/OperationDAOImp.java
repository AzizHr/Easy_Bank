package daoImplementaion;

import dao.IOperationDAO;
import entities.Operation;
import java.util.Optional;

public class OperationDAOImp implements IOperationDAO<Operation> {
    /**
     * @param operation 
     * @return
     */
    @Override
    public Optional<Operation> save(Operation operation) {
        return Optional.empty();
    }

    /**
     * @param operation 
     * @return
     */
    @Override
    public Optional<Boolean> delete(Operation operation) {
        return Optional.empty();
    }

    /**
     * @param number 
     * @return
     */
    @Override
    public Optional<Operation> findByNumber(String number) {
        return Optional.empty();
    }
}
