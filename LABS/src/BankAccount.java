public class BankAccount {
    public String accountNumber;
    public String accountName;
    public double balance;
    public boolean suspended= false;

    public BankAccount(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (suspended) {
            System.out.println("Cannot deposit. Account is suspended.");
        } else if(amount<=0){
            System.out.println("Cannot deposit. Deposit amount is no more than zero");
        } else{
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (suspended) {
            System.out.println("Cannot withdraw. Account is suspended.");
        }else if(balance<amount){
            System.out.println("Cannot withdraw. Insufficient balance.");
        }else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountName() {
        return accountName;
    }
    public void suspend() {
        suspended = true;
        System.out.println("Account " + accountNumber + " is suspended.");
    }
    public void resume() {
        suspended = false;
        System.out.println("Account " + accountNumber + " is resumed.");
    }
}