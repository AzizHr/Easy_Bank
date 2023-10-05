package services;

import daoImplementaion.RecruitmentHistoryDAOImp;

public class RecruitmentHistoryService {

    public static RecruitmentHistoryDAOImp recruitmentHistoryDAOImp;

    public RecruitmentHistoryService(RecruitmentHistoryDAOImp instance) {
        recruitmentHistoryDAOImp = instance;
    }

}
