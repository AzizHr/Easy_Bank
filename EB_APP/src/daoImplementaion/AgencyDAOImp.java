package daoImplementaion;

import dao.IAgencyDAO;
import database.Database;
import entities.Agency;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
