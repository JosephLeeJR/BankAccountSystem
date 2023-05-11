public class CurrentAccount extends BankAccount {
    public double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
        overdraftLimit = 500.0;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void withdraw(double amount) {
        if(!suspended) {
            if (amount > getBalance() + overdraftLimit) {
                System.out.println("Withdrawal not allowed. Overdraft limit exceeded.");
            } else {
                balance -= amount;
            }
        }else{
            System.out.println("Cannot withdraw. Account is suspended.");
        }
    }
}


