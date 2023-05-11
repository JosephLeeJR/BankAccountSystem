import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account=new BankAccount("123","Li",500);
        account.deposit(100);
        assertEquals(account.balance,600);
        account.deposit(-100);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        BankAccount account=new BankAccount("123","Li",500);
        account.withdraw(400);
        assertEquals(account.balance,100);
        account.withdraw(700);
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        BankAccount account=new BankAccount("123","Li",500);
        assertEquals(account.getBalance(),500);
    }

    @org.junit.jupiter.api.Test
    void getAccountNumber() {
        BankAccount account=new BankAccount("123","Li",500);
        assertEquals(account.getAccountNumber(),"123");
    }

    @org.junit.jupiter.api.Test
    void getAccountName() {
        BankAccount account=new BankAccount("123","Li",500);
        assertEquals(account.getAccountName(),"Li");
    }

    @org.junit.jupiter.api.Test
    void suspend() {
        BankAccount account=new BankAccount("123","Li",500);
        account.suspend();
        assertTrue(account.suspended);
    }

    @org.junit.jupiter.api.Test
    void resume() {
        BankAccount account=new BankAccount("123","Li",500);
        account.suspend();
        assertTrue(account.suspended);
        account.resume();
        assertFalse(account.suspended);
    }
}