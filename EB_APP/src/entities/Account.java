package entities;

import enums.accountStatus;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public abstract class Account {

    private String number;
    private double balance;
    private LocalDate createdAt;
    private accountStatus status;
    private Client client;
    private Employee employee;
    private List<Operation> operations;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public accountStatus getStatus() {
        return status;
    }

    public void setStatus(accountStatus status) {
        this.status = status;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
