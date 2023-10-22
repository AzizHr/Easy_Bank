package services;

import daoImplementaion.RecruitmentHistoryDAOImp;
import entities.RecruitmentHistory;
import java.util.Collections;
import java.util.List;

public class RecruitmentHistoryService {

    public  RecruitmentHistoryDAOImp recruitmentHistoryDAOImp;

    public RecruitmentHistoryService(RecruitmentHistoryDAOImp instance) {
        recruitmentHistoryDAOImp = instance;
    }

    public  RecruitmentHistory assignAnEmployeeToAnAgency(RecruitmentHistory recruitmentHistory) {

        return recruitmentHistoryDAOImp.assignAnEmployeeToAnAgency(recruitmentHistory).orElse(null);
    }

    public  List<RecruitmentHistory> findAll() {

        return recruitmentHistoryDAOImp.findAll().orElse(Collections.emptyList());
    }
}
