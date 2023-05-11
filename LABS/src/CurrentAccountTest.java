import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {

    @Test
    void setOverdraftLimit() {
        CurrentAccount account=new CurrentAccount("123","li",500);
        assertEquals(500,account.overdraftLimit);
        account.setOverdraftLimit(1000);
        assertEquals(1000,account.overdraftLimit);
    }

    @Test
    void getOverdraftLimit() {
        CurrentAccount account=new CurrentAccount("123","li",500);
        assertEquals(500,account.getOverdraftLimit());
    }

    @Test
    void withdraw() {
        CurrentAccount account=new CurrentAccount("123","li",500);
        account.withdraw(700);
        assertEquals(-200,account.balance);
    }
}