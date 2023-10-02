package entities;

import java.util.List;

public class Client extends Person {

    private String adress;
    private List<Account> accounts;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return  "\nClient Information => {"+
                " Code : "+this.getCode()+", "+
                " First Name : "+this.getFirstName()+", "+
                " Last Name : "+this.getLastName()+", "+
                " BirthDate : "+this.getBirthDate()+", "+
                " Phone Number : "+this.getPhoneNumber()+", "+
                " Adress : "+this.getAdress()+
                " }";
    }
}
