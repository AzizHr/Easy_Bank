package controllers;

import entities.*;
import enums.paymentType;
import services.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PaymentController {

    private final PaymentService paymentService;
    private final EmployeeService employeeService;
    private final CurrentAccountService currentAccountService;
    private final SavingAccountService savingAccountService;
    private static final Scanner scanner = new Scanner(System.in);

    public PaymentController(PaymentService instance1, EmployeeService instance2, CurrentAccountService instance3, SavingAccountService instance4) {
        paymentService = instance1;
        employeeService = instance2;
        currentAccountService = instance3;
        savingAccountService = instance4;
    }

    public void saveForCurrentAccount() {

        System.out.print("Enter The Employee Code Who Will Do This Payment -> ");
        String employeeCode = scanner.next();
        Employee employee = employeeService.findByCode(employeeCode);
        if(employee != null) {
            System.out.print("Enter The (SOURCE) Current Account Number -> ");
            String sourceCurrentAccountNumber = scanner.next();

            CurrentAccount sourceCurrentAccount = currentAccountService.findByNumber(sourceCurrentAccountNumber);
            if(sourceCurrentAccount != null) {
                System.out.print("Enter The (DESTINATION) Current Account Number -> ");
                String destinationCurrentAccountNumber = scanner.next();
                CurrentAccount destinationCurrentAccount = currentAccountService.findByNumber(destinationCurrentAccountNumber);
                if(destinationCurrentAccount != null) {
                    Payment payment = new Payment();
                    System.out.print("Enter The Payment Number -> ");
                    String number = scanner.next();
                    payment.setNumber(number);
                    LocalDateTime createdAt = LocalDateTime.now();
                    payment.setCreatedAt(createdAt);
                    System.out.print("Enter The Price -> ");
                    double price = scanner.nextDouble();
                    payment.setPayment(paymentType.PAYMENT);
                    payment.setPrice(price);
                    payment.setEmployee(employee);
                    payment.setAccount(sourceCurrentAccount);
                    currentAccountService.withdraw(price, sourceCurrentAccountNumber);
                    payment.setDestinationAccount(destinationCurrentAccount);
                    currentAccountService.deposit(price, destinationCurrentAccountNumber);
                    if(paymentService.saveForCA(payment) != null) {
                        System.out.println("Payed with success!");
                    }
                }

            }
        }

    }

    public void saveForSavingAccount() {

        System.out.print("Enter The Employee Code Who Will Do This Payment -> ");
        String employeeCode = scanner.next();
        Employee employee = employeeService.findByCode(employeeCode);
        if(employee != null) {
            System.out.print("Enter The (SOURCE) Saving Account Number -> ");
            String sourceSavingAccountNumber = scanner.next();

            SavingAccount sourceSavingAccount = savingAccountService.findByNumber(sourceSavingAccountNumber);
            if(sourceSavingAccount != null) {
                System.out.print("Enter The (DESTINATION) Saving Account Number -> ");
                String destinationSavingAccountNumber = scanner.next();
                SavingAccount destinationSavingAccount = savingAccountService.findByNumber(destinationSavingAccountNumber);
                if(destinationSavingAccount != null) {
                    Payment payment = new Payment();
                    System.out.print("Enter The Payment Number -> ");
                    String number = scanner.next();
                    payment.setNumber(number);
                    LocalDateTime createdAt = LocalDateTime.now();
                    payment.setCreatedAt(createdAt);
                    System.out.print("Enter The Price -> ");
                    double price = scanner.nextDouble();
                    payment.setPayment(paymentType.PAYMENT);
                    payment.setPrice(price);
                    payment.setEmployee(employee);
                    payment.setAccount(sourceSavingAccount);
                    savingAccountService.withdraw(price, sourceSavingAccountNumber);
                    payment.setDestinationAccount(destinationSavingAccount);
                    savingAccountService.deposit(price, destinationSavingAccountNumber);
                    if(paymentService.saveForCA(payment) != null) {
                        System.out.println("Payed with success!");
                    }
                }

            }
        }
    }


    public void findByNumber() {
        System.out.print("Enter The Number Of The Payment You're Looking For -> ");
        String number = scanner.next();
        System.out.println(paymentService.findByNumber(number));
    }


    public void delete() {

        System.out.print("Enter The Number Of The Payment You Wanna Delete -> ");
        String number = scanner.next();
        if(paymentService.delete(number)) {
            System.out.println("Deleted With Success!");
        }

    }

}

