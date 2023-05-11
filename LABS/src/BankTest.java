import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testOpenAccount() {
        // Test opening a valid Junior account
        bank.openAccount("John Doe", "123 Main Street", "2007-05-15", "Junior");
        int numAccounts = bank.getNumberOfAccounts();
        Assertions.assertEquals(1, numAccounts);

        // Test opening a valid Current account
        bank.openAccount("Jane Smith", "456 Elm Street", "1990-10-20", "Current");
        numAccounts = bank.getNumberOfAccounts();
        Assertions.assertEquals(2, numAccounts);

        // Test opening a Junior account for a customer over 16 years old
        bank.openAccount("Bob Brown", "789 Oak Street", "2000-01-01", "Junior");
        numAccounts = bank.getNumberOfAccounts();
        Assertions.assertEquals(2, numAccounts); // Account should not be opened
    }

    @Test
    public void testDeposit() {
        // Open a Current account
        bank.openAccount("John Doe", "123 Main Street", "2000-01-01", "Current");

        // Test depositing into the account
        bank.deposit("000001", 500.0);
        double balance = bank.getBalance("000001");
        Assertions.assertEquals(500.0, balance);

        // Test depositing a negative amount
        bank.deposit("000001", -100.0);
        balance = bank.getBalance("000001");
        Assertions.assertEquals(500.0, balance); // Balance should remain the same
    }

    @Test
    public void testWithdraw() {
        // Open a Current account
        bank.openAccount("John Doe", "123 Main Street", "2000-01-01", "Current");

        // Deposit initial amount
        bank.deposit("000001", 1000.0);

        // Test withdrawing from the account
        bank.withdraw("000001", 500.0);
        double balance = bank.getBalance("000001");
        Assertions.assertEquals(500.0, balance);

        // Test withdrawing more than the available balance
        bank.withdraw("000001", 1100.0);
        balance = bank.getBalance("000001");
        Assertions.assertEquals(500.0, balance); // Balance should remain the same
    }

    @Test
    public void testCloseAccount() {
        // Open two accounts
        bank.openAccount("John Doe", "123 Main Street", "2000-01-01", "Current");
        bank.openAccount("Jane Smith", "456 Elm Street", "1990-10-20", "Current");

        // Test closing an existing account
        bank.closeAccount("000001");
        int numAccounts = bank.getNumberOfAccounts();
        Assertions.assertEquals(1, numAccounts);

        // Test closing a non-existent account
        bank.closeAccount("000003");
        numAccounts = bank.getNumberOfAccounts();
        Assertions.assertEquals(1, numAccounts);
    }
}
