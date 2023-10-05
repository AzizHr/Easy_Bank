package services;

import daoImplementaion.DemandDAOImp;

public class DemandService {

    public static DemandDAOImp demandDAOImp;

    public DemandService(DemandDAOImp instance) {
        demandDAOImp = instance;
    }

}
