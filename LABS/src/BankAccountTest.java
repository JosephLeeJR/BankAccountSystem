import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("000001", "John Doe", 1000.0);
    }

    @Test
    public void testGetAccountNumber() {
        String accountNumber = account.getAccountNumber();
        Assertions.assertEquals("000001", accountNumber);
    }

    @Test
    public void testGetAccountName() {
        String accountName = account.getAccountName();
        Assertions.assertEquals("John Doe", accountName);
    }

    @Test
    public void testGetBalance() {
        double balance = account.getBalance();
        Assertions.assertEquals(1000.0, balance);
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);
        double balance = account.getBalance();
        Assertions.assertEquals(1500.0, balance);
    }

    @Test
    public void testWithdrawSufficientBalance() {
        account.withdraw(500.0);
        double balance = account.getBalance();
        Assertions.assertEquals(500.0, balance);
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        account.withdraw(1500.0);
        double balance = account.getBalance();
        Assertions.assertEquals(1000.0, balance); // Balance should remain the same
    }
}
