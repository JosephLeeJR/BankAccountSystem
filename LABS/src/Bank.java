import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    public List<BankAccount> accounts;
    public Map<String, Customer> customers;
    public int accountCounter;

    public Bank() {
        accounts = new ArrayList<>();
        customers = new HashMap<>();
        accountCounter = 0;
    }

    public void openAccount(String name, String address, String dateOfBirth, String accountType) {
        Customer customer = new Customer(name, address, dateOfBirth);
        CreditAgency creditAgency = new CreditAgency();
        boolean creditStatus = creditAgency.verifyCreditStatus(customer);

        if (!creditStatus) {
            System.out.println("Account opening failed. Customer has unsatisfactory credit history.");
            return;
        }

        BankAccount account;
        if (accountType.equalsIgnoreCase("Junior")) {
            if (customer.getAge() >= 16) {
                System.out.println("Account opening failed. Junior account can only be opened for customers under 16 years old.");
                return;
            }
            account = new JuniorAccount(generateAccountNumber(), name, 0.0, customer.getAge());
        } else if (accountType.equalsIgnoreCase("Current")) {
            account = new CurrentAccount(generateAccountNumber(), name, 0.0);
        } else {
            account = new BankAccount(generateAccountNumber(), name, 0.0);
        }

        accounts.add(account);
        customers.put(account.getAccountNumber(), customer);
        String pin = generatePIN();
        customer.setPIN(pin);
        System.out.println("Account opened successfully.");
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("PIN: " + pin);
    }

    public void closeAccount(String accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        accounts.remove(account);
        customers.remove(accountNumber);
        System.out.println("Account closed successfully.");
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.withdraw(amount);
        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
    }

    public double getBalance(String accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return 0.0;
        }

        return account.getBalance();
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private String generateAccountNumber() {
        accountCounter++;
        return String.format("%06d", accountCounter);
    }

    private String generatePIN() {
        int pin = (int) (Math.random() * 9000) + 1000;
        return String.valueOf(pin);
    }
}
