package services;

import daoImplementaion.AgencyDAOImp;

public class AgencyService {

    public static AgencyDAOImp agencyDAOImp;

    public AgencyService(AgencyDAOImp instance) {
        agencyDAOImp = instance;
    }



}
