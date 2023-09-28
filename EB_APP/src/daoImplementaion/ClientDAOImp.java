package daoImplementaion;

import dao.IClientDAO;
import database.Database;
import entities.Client;
import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Client client = new Client();
        String sql = "SELECT * FROM employee WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                client.setCode(rs.getString(1));
                client.setFirstName(rs.getString(2));
                client.setLastName(rs.getString(3));
                client.setBirthDate(rs.getDate(4).toLocalDate());
                client.setPhoneNumber(rs.getString(5));
                client.setAdress(rs.getString(6));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to select");
        }
        return Optional.of(client);
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
        boolean deleted = false;
        String sql = "DELETE FROM employee WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getCode());
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to delete");
        }
        return deleted;
    }

    /**
     * @param client 
     * @return
     */
    @Override
    public boolean update(Client client) {
        boolean updated = false;

        String sql = "UPDATE client SET first_name = ?, last_name = ?, birth_date = ?, phone_number = ?, adress = ? WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setObject(3, client.getBirthDate());
            preparedStatement.setString(4, client.getPhoneNumber());
            preparedStatement.setString(5, client.getAdress());
            preparedStatement.setString(6, client.getCode());
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    /**
     * @return 
     */
    @Override
    public Optional<List<Client>> findAll() {
        return Optional.empty();
    }
}
