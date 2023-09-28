package entities;

import java.time.LocalDate;
import java.util.List;

public class Employee extends Person {

    private String email;
    private LocalDate recruitedAt;
    private List<Operation> operations;
    private List<MissionHistory> missionHistories;

    public Employee() {

    }
    public Employee(String code) {
        super(code);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Operation> getOperations() {
        return operations;
    }
    public LocalDate getRecruitedAt() {
        return recruitedAt;
    }

    public void setRecruitedAt(LocalDate recruitedAt) {
        this.recruitedAt = recruitedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<MissionHistory> getMissionHistories() {
        return missionHistories;
    }

    public void setMissionHistories(List<MissionHistory> missionHistories) {
        this.missionHistories = missionHistories;
    }

    @Override
    public String toString() {
        return  "\nEmployee Information => {"+
                " Code : "+this.getCode()+", "+
                " First Name : "+this.getFirstName()+", "+
                " Last Name : "+this.getLastName()+
                " }";
    }
}
