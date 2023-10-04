package daoImplementaion;

import dao.IDemandDAO;
import entities.Demand;

import java.util.List;
import java.util.Optional;

public class DemandDAOImp implements IDemandDAO<Demand> {
    /**
     * @param demand 
     * @return
     */
    @Override
    public Optional<Demand> save(Demand demand) {
        return Optional.empty();
    }

    /**
     * @param ID 
     * @return
     */
    @Override
    public boolean delete(String ID) {
        return false;
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Demand>> findAll() {
        return Optional.empty();
    }
}
