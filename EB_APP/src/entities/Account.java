package entities;

import enums.accountStatus;

import java.util.List;
import java.util.Locale;

public abstract class Account {

    private String number;
    private float balance;
    private Locale createdAt;
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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Locale getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Locale createdAt) {
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
