package entities;

import enums.demandStatus;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Simulation {

    private String number;
    private LocalDate createdAt;
    private demandStatus status;
    private double price;
    private int duration;
    private double paidMonthly;
    private String remarks;
    private Client client;
    private Agency agency;

}
