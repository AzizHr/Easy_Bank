package entities;

public class CurrentAccount extends Account {

    private float overdraft;

    public float getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(float overdraft) {
        this.overdraft = overdraft;
    }
}
