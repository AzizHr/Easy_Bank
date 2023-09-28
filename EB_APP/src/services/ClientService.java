package services;

import daoImplementaion.ClientDAOImp;
import entities.Client;

import java.util.List;
import java.util.Optional;

public class ClientService {

    private static final ClientDAOImp clientDAOImp = new ClientDAOImp();
    public static Optional<Client> save(Client client) {

        return clientDAOImp.save(client);

    }

    public static Optional<Client> findByCode(String code) {
        return clientDAOImp.findByCode(code);
    }

    public static boolean delete(Client client) {
        return clientDAOImp.delete(client);
    }

    public static Optional<List<Client>> findAll() {
        return clientDAOImp.findAll();
    }

}
