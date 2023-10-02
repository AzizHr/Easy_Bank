package services;

import daoImplementaion.ClientDAOImp;
import entities.Client;
import entities.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClientService {

    private static final ClientDAOImp clientDAOImp = new ClientDAOImp();

    public static void save(Client client) {

        System.out.println("New Client Added With Success!");
        clientDAOImp.save(client).ifPresent(System.out::println);

    }

    public static void delete(String code) {

        if(clientDAOImp.delete(code)) {
            System.out.println("Deleted With Success!");
        } else {
            System.out.println("Not Found!");
        }

    }

    public static void findAll() {
        List<Client> clients = clientDAOImp.findAll().orElse(Collections.emptyList());

        if (clients.isEmpty()) {
            System.out.println("No Clients Found!");
        } else {
            clients.forEach(System.out::println);
        }
    }

    public static void findByCode(String code) {

        Optional<Client> clientOptional = clientDAOImp.findByCode(code);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            System.out.println("Employee Found : ");
            System.out.println(client);
        } else {
            System.out.println("No Client With This Code Found!");
        }
    }

    public static Client getOne(String code) {

        Optional<Client> clientOptional = clientDAOImp.findByCode(code);

        return clientOptional.orElse(null);
    }

    public static void findByAdress(String adress) {

        Optional<Client> clientOptional = clientDAOImp.findByAdress(adress);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            System.out.println("Client Found : ");
            System.out.println(client);
        } else {
            System.out.println("No Client With This Adress Found!");
        }

    }

    public static void update(Client client) {

        if(clientDAOImp.update(client)) {
            System.out.println("Updated With Success!");
        } else {
            System.out.println("Error!");
        }

    }

}
