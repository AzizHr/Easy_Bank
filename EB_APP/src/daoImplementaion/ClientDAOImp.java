package daoImplementaion;

import dao.IClientDAO;
import entities.Client;
import java.util.List;
import java.util.Optional;

public class ClientDAOImp implements IClientDAO<Client> {
    /**
     * @param code 
     * @return
     */
    @Override
    public Optional<Client> findByCode(String code) {
        return Optional.empty();
    }

    /**
     * @param client 
     * @return
     */
    @Override
    public Optional<Client> save(Client client) {
        return Optional.empty();
    }

    /**
     * @param client 
     * @return
     */
    @Override
    public Optional<Boolean> delete(Client client) {
        return Optional.empty();
    }

    /**
     * @param client 
     * @return
     */
    @Override
    public Optional<Boolean> update(Client client) {
        return Optional.empty();
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Client>> findAll() {
        return Optional.empty();
    }
}
