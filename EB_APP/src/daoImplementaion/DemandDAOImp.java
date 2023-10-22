package daoImplementaion;

import dao.IDemandDAO;
import database.Database;
import entities.*;
import enums.demandStatus;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemandDAOImp implements IDemandDAO<Simulation> {

    private static final Connection connection = Database.getInstance().getConnection();
    private static final ClientDAOImp clientDAOImp = new ClientDAOImp();
    private static final AgencyDAOImp agencyDAOImp = new AgencyDAOImp();

    /**
     * @param simulation 
     * @return
     */
    @Override
    public Optional<Simulation> save(Simulation simulation) {
        String sql = "INSERT INTO demand (number, create_at, status, price, duration, paid_monthly, remarks, client_code, agency_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        double paidMonthly = (simulation.getPrice() * (0.05 / 12)) / (1 - Math.pow((1 + (0.05 / 12)), -simulation.getDuration()));
        simulation.setPaidMonthly(paidMonthly);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, simulation.getNumber());
            preparedStatement.setObject(2, simulation.getCreatedAt());
            preparedStatement.setObject(3, simulation.getStatus(), Types.OTHER);
            preparedStatement.setDouble(4, simulation.getPrice());
            preparedStatement.setInt(5, simulation.getDuration());
            preparedStatement.setDouble(6, simulation.getPaidMonthly());
            preparedStatement.setString(7, simulation.getRemarks());
            preparedStatement.setString(8, simulation.getClient().getCode());
            preparedStatement.setString(9, simulation.getAgency().getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(simulation);
    }

    /**
     * @param number
     * @return
     */
    @Override
    public boolean delete(String number) {
        boolean deleted = false;
        String sql = "DELETE FROM demand WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
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
    public Optional<List<Simulation>> findAll() {
        List<Simulation> demands = new ArrayList<>();

        String sql = "SELECT * FROM demand";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Simulation demand = new Simulation();
                demand.setNumber(rs.getString(1));
                demand.setCreatedAt(rs.getDate(2).toLocalDate());
                demand.setStatus(demandStatus.valueOf(rs.getString(3)));
                demand.setPrice(rs.getDouble(4));
                demand.setDuration(rs.getInt(5));
                demand.setPaidMonthly(rs.getDouble(6));
                demand.setRemarks(rs.getString(7));
                demand.setClient(clientDAOImp.findByCode(rs.getString(8)).get());
                demand.setAgency(agencyDAOImp.findByCode(rs.getString(9)).get());
                demands.add(demand);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(demands);
    }

    /**
     * @param number 
     * @return
     */
    @Override
    public Optional<Simulation> findByNumber(String number) {
        Demand demand = new Demand();
        String sql = "SELECT * FROM demand WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {

                demand.setNumber(rs.getString(1));
                demand.setCreatedAt(rs.getDate(2).toLocalDate());
                demand.setStatus(demandStatus.valueOf(rs.getString(3)));
                demand.setPrice(rs.getDouble(4));
                demand.setDuration(rs.getInt(5));
                demand.setPaidMonthly(rs.getDouble(6));
                demand.setRemarks(rs.getString(7));
                demand.setClient(clientDAOImp.findByCode(rs.getString(8)).get());
                demand.setAgency(agencyDAOImp.findByCode(rs.getString(9)).get());
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("Error when trying to select");
        }
        return Optional.of(demand);
    }

    /**
     * @param status 
     * @param number
     * @return
     */
    @Override
    public boolean updateStatus(demandStatus status, String number) {
        boolean updated = false;
        String sql = "UPDATE demand SET status = ? WHERE number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, status, Types.OTHER);
            preparedStatement.setString(2, number);
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }
}
