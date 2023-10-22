package services;

import daoImplementaion.DemandDAOImp;
import entities.Demand;
import entities.Simulation;
import enums.demandStatus;
import java.util.Collections;
import java.util.List;

public class DemandService {

    public  DemandDAOImp demandDAOImp;

    public DemandService(DemandDAOImp instance) {
        demandDAOImp = instance;
    }

    public  Simulation save(Demand demand) {

        return demandDAOImp.save(demand).orElse(null);

    }

    public  boolean delete(String code) {

        return demandDAOImp.delete(code);
    }

    public  List<Simulation> findAll() {

        return demandDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  Simulation findByNumber(String number) {

        return demandDAOImp.findByNumber(number).orElse(null);
    }

    public  boolean updateStatus(demandStatus status, String number) {
        return demandDAOImp.updateStatus(status, number);
    }

}
