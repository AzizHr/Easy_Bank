package entities;

import enums.paymentType;
import java.util.Locale;

public class Operation {

    private String number;
    private Locale createdAt;
    private float price;
    private paymentType payment;
    private Account account;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Locale getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Locale createdAt) {
        this.createdAt = createdAt;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public paymentType getPayment() {
        return payment;
    }

    public void setPayment(paymentType payment) {
        this.payment = payment;
    }
}