package entities;

import enums.demandStatus;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Demand {

    private String number;
    private LocalDate date;
    private demandStatus status;
    private double price;
    private int duration;

    @Override
    public String toString() {
        return "Demand{" +
                "number='" + number + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }
}
