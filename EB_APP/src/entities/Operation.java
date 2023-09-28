package entities;

import enums.paymentType;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

public class Operation {

    private String number;
    private LocalDate createdAt;
    private double price;
    private paymentType payment;
    private Employee employee;
    private Account account;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public paymentType getPayment() {
        return payment;
    }

    public void setPayment(paymentType payment) {
        this.payment = payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
