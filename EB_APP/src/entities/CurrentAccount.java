package entities;

import enums.accountStatus;

import java.time.LocalDate;

public class CurrentAccount extends Account {

    private double overdraft;

    public CurrentAccount() {}

    public CurrentAccount(String number, double balance, LocalDate createdAt, accountStatus status, Client client, Employee employee, double overdraft) {
        super(number, balance, createdAt, status, client, employee);
        setOverdraft(overdraft);
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }



    @Override
    public String toString() {
        return  "\nCurrent Account Information => {"+
                " Number : "+this.getNumber()+", "+
                " Balance : "+this.getBalance()+", "+
                " Created At : "+this.getCreatedAt()+", "+
                " Status : "+this.getStatus()+", "+
                " Overdraft : "+this.getOverdraft()+", "+
                " Created For : "+this.getClient().getFirstName()+" "+this.getClient().getLastName()+", "+
                " Created By : "+this.getEmployee().getFirstName()+" "+this.getEmployee().getLastName()+
                " }";
    }
}
