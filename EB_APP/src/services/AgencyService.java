package services;

import daoImplementaion.AgencyDAOImp;
import entities.Agency;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AgencyService {

    public  AgencyDAOImp agencyDAOImp;

    public AgencyService(AgencyDAOImp instance) {
        agencyDAOImp = instance;
    }

    public  Agency save(Agency agency) {

        return agencyDAOImp.save(agency).orElse(null);

    }

    public  boolean delete(String code) {

        return agencyDAOImp.delete(code);
    }

    public  List<Agency> findAll() {

        return agencyDAOImp.findAll().orElse(Collections.emptyList());
    }

    public  Agency findByCode(String code) {

        return agencyDAOImp.findByCode(code).orElse(null);
    }

    public  Agency findByAddress(String address) {

        return agencyDAOImp.findByAddress(address).orElse(null);
    }

    public  boolean update(Agency agency) {

        return agencyDAOImp.update(agency);
    }

}
