package controllers;

import entities.*;
import enums.demandStatus;
import services.AgencyService;
import services.ClientService;
import services.DemandService;
import java.time.LocalDate;
import java.util.Scanner;

public class DemandController {

    private final DemandService demandService;
    private final AgencyService agencyService;
    private final ClientService clientService;
    private static final Scanner scanner = new Scanner(System.in);

    public DemandController(DemandService instance1, AgencyService instance2, ClientService instance3) {
        demandService = instance1;
        agencyService = instance2;
        clientService = instance3;
    }

    public void save() {

        Demand demand = new Demand();
        System.out.print("Enter The Simulation Number -> ");
        String number = scanner.next();
        demand.setNumber(number);
        LocalDate createdAt = LocalDate.now();
        demand.setCreatedAt(createdAt);
        System.out.println("Choose The Status : ");
        System.out.println("1- Accepted : ");
        System.out.println("2- Pending  : ");
        System.out.println("3- Rejected : ");
        int status = scanner.nextInt();
        switch (status) {
            case 1:
                demand.setStatus(demandStatus.ACCEPTED);
                break;
            case 2:
                demand.setStatus(demandStatus.PENDING);
                break;
            case 3:
                demand.setStatus(demandStatus.REJECTED);
            default:
                System.out.println("Invalid Choice!");
        }

        System.out.print("Enter The Simulation Price -> ");
        double price = scanner.nextDouble();
        demand.setPrice(price);
        System.out.print("Enter The Simulation Duration -> ");
        int duration = scanner.nextInt();
        demand.setDuration(duration);
        System.out.print("Enter some remarks -> ");
        String remarks = scanner.next();
        demand.setRemarks(remarks);
        System.out.println("Enter The Agency Code That Will Own This Demand -> ");
        String createdIn = scanner.next();
        Agency agency = agencyService.findByCode(createdIn);
        System.out.println("Enter The Client Code Who Will Own This Demand -> ");
        String createdFor = scanner.next();
        Client client = clientService.findByCode(createdFor);
        demand.setClient(client);
        demand.setAgency(agency);
        System.out.print("Do You Confirm This Simulation (Y/N) ->");
        String confirmation = scanner.next();

        if(confirmation.equals("Y")) {
            System.out.println(demandService.save(demand));
        }

    }

    public void findAll() {
        demandService.findAll();
    }

    public void findByNumber() {
        System.out.print("Enter The Number Of The Demand You're Looking For -> ");
        String demandNumber = scanner.next();
        System.out.println(demandService.findByNumber(demandNumber));
    }

    public void updateStatus() {
        System.out.print("Enter The Number Of The Demand You Wanna Update -> ");
        String number = scanner.next();

        if(demandService.findByNumber(number) != null) {

            Demand demand = new Demand();
            System.out.println("Choose The Status : ");
            System.out.println("1- : ");
            System.out.println("2- : ");
            System.out.println("3- : ");
            int status = scanner.nextInt();
            switch (status) {
                case 1:
                    demandService.updateStatus(demandStatus.ACCEPTED, number);
                    break;
                case 2:
                    demandService.updateStatus(demandStatus.PENDING, number);
                    break;
                case 3:
                    demandService.updateStatus(demandStatus.REJECTED, number);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }


    public void delete() {

        System.out.print("Enter The Number Of The Demand You Wanna Delete -> ");
        String clientCodeToDelete = scanner.next();
        if(demandService.delete(clientCodeToDelete)) {
            System.out.println("Deleted With Success!");
        }

    }

}
