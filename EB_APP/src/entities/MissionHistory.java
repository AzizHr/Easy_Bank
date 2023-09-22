package entities;

import java.util.Locale;

public class MissionHistory {

    private Employee employee;
    private  Mission mission;
    private Locale startedAt;
    private Locale endedAt;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Locale getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Locale startedAt) {
        this.startedAt = startedAt;
    }

    public Locale getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Locale endedAt) {
        this.endedAt = endedAt;
    }
}
