package entities;

import java.util.List;

public class Mission {

    private String code;
    private String name;
    private String description;
    private List<MissionHistory> missionHistories;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MissionHistory> getMissionHistories() {
        return missionHistories;
    }

    public void setMissionHistories(List<MissionHistory> missionHistories) {
        this.missionHistories = missionHistories;
    }
}
