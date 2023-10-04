package daoImplementaion;

import dao.IAgencyDAO;
import entities.Agency;

import java.util.List;
import java.util.Optional;

public class AgencyDAOImp implements IAgencyDAO<Agency> {
    /**
     * @param agency 
     * @return
     */
    @Override
    public Optional<Agency> save(Agency agency) {
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
    public Optional<List<Agency>> findAll() {
        return Optional.empty();
    }

    /**
     * @param agency 
     * @return
     */
    @Override
    public Optional<Agency> update(Agency agency) {
        return Optional.empty();
    }

    /**
     * @param code 
     * @return
     */
    @Override
    public Optional<Agency> findByCode(String code) {
        return Optional.empty();
    }

    /**
     * @param adress 
     * @return
     */
    @Override
    public Optional<Agency> findByAdress(String adress) {
        return Optional.empty();
    }

    /**
     * @param agency 
     * @return
     */
    @Override
    public Optional<List<Agency>> findByEmployee(Agency agency) {
        return Optional.empty();
    }
}
