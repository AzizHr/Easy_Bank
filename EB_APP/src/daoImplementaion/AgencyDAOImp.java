package daoImplementaion;

import dao.IAgencyDAO;
import database.Database;
import entities.Agency;
import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AgencyDAOImp implements IAgencyDAO<Agency> {

    private static final Connection connection = Database.getInstance().getConnection();
    /**
     * @param agency 
     * @return
     */
    @Override
    public Optional<Agency> save(Agency agency) {
        String sql = "INSERT INTO agency (code, name, address, phone_number) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, agency.getCode());
            preparedStatement.setString(2, agency.getName());
            preparedStatement.setString(3, agency.getAdress());
            preparedStatement.setString(4, agency.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(agency);
    }

    /**
     * @param code
     * @return
     */
    @Override
    public boolean delete(String code) {
        boolean deleted = false;
        String sql = "DELETE FROM agency WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            deleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error when trying to delete");
        }
        return deleted;
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
        Agency agency = new Agency();
        String sql = "SELECT * FROM agency WHERE code = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                agency.setCode(rs.getString(1));
                agency.setName(rs.getString(2));
                agency.setAdress(rs.getString(3));
                agency.setPhoneNumber(rs.getString(4));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to select");
        }
        return Optional.of(agency);
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
