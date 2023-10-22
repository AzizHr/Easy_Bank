package controllers;

import entities.Agency;
import entities.Client;
import services.AgencyService;
import services.ClientService;

import java.time.LocalDate;
import java.util.Scanner;

public class AgencyController {

    private final AgencyService agencyService;
    private static final Scanner scanner = new Scanner(System.in);

    public AgencyController(AgencyService instance) {
        agencyService = instance;
    }

    public void save() {

        Agency agency = new Agency();
        System.out.print("Enter The Agency Code -> ");
        String code = scanner.next();
        agency.setCode(code);
        System.out.print("Enter The Agency Name -> ");
        String name = scanner.next();
        agency.setName(name);
        System.out.print("Enter The Agency Address -> ");
        String address = scanner.next();
        agency.setAddress(address);
        System.out.print("Enter The Agency Phone Number -> ");
        String phoneNumber = scanner.next();
        agency.setPhoneNumber(phoneNumber);
        System.out.println(agencyService.save(agency));

    }

    public void findAll() {
        agencyService.findAll();
    }

    public void findByCode() {
        System.out.print("Enter The Code Of The Agency You're Looking For -> ");
        String agencyCode = scanner.next();
        System.out.println(agencyService.findByCode(agencyCode));
    }

    public void update() {
        System.out.print("Enter The Code Of The Agency You Wanna Update -> ");
        String code = scanner.next();

        if(agencyService.findByCode(code) != null) {

            System.out.println("Enter The New Information");
            Agency agency = new Agency();
            agency.setCode(code);
            System.out.print("Enter The Agency Name -> ");
            String name = scanner.next();
            agency.setName(name);
            System.out.print("Enter The Agency Address -> ");
            String address = scanner.next();
            agency.setAddress(address);
            System.out.print("Enter The Client Phone Number -> ");
            String phoneNumber = scanner.next();
            agency.setPhoneNumber(phoneNumber);
            System.out.println(agencyService.update(agency));
        }
    }

    public void findByAddress() {
        System.out.print("Enter The Address Of The Agency You're Looking For -> ");
        String agencyAddress = scanner.next();
        System.out.println(agencyService.findByAddress(agencyAddress));

    }

    public void delete() {

        System.out.print("Enter The Code Of The Agency You Wanna Delete -> ");
        String clientCodeToDelete = scanner.next();
        if(agencyService.delete(clientCodeToDelete)) {
            System.out.println("Deleted With Success!");
        }

    }

}
