import java.util.ArrayList;
public class Bank {
    public ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }

    public void openAccount(BankAccount account) {
        accounts.add(account);
    }

    public void closeAccount(BankAccount account) {
        accounts.remove(account);
    }

    public void infoAboutAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("Account number: " + account.getAccountNumber());
            System.out.println("Account name: " + account.getAccountName());
            System.out.println("Account balance: " + account.getBalance());
            if (account instanceof CurrentAccount) {
                if (account.getBalance() < 0) {
                    System.out.println("Overdraft state.");
                }
            }
        }
    }
}
