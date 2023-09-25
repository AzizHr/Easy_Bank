package daoImplementaion;

import dao.IClientDAO;
import database.Database;
import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientDAOImp implements IClientDAO<Client> {

    private static final Connection connection = Database.getInstance().getConnection();

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

        String sql = "INSERT INTO client (code, first_name, last_name, birth_date, phone_number, adress) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getCode());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setObject(4, client.getBirthDate());
            preparedStatement.setString(5, client.getPhoneNumber());
            preparedStatement.setString(6, client.getAdress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(client);
    }

    /**
     * @param client
     * @return
     */
    @Override
    public boolean delete(Client client) {
        return false;
    }

    /**
     * @param client 
     * @return
     */
    @Override
    public int update(Client client) {
        return 0;
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Client>> findAll() {
        return Optional.empty();
    }
}
