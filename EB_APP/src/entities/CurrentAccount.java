package entities;

public class CurrentAccount extends Account {

    private double overdraft;

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
