package entities;

import java.time.LocalDate;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee extends Person {

    private String email;
    private LocalDate recruitedAt;
    private List<Operation> operations;
    private List<MissionHistory> missionHistories;

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", recruitedAt=" + recruitedAt +
                ", operations=" + operations +
                ", missionHistories=" + missionHistories +
                '}';
    }
}
