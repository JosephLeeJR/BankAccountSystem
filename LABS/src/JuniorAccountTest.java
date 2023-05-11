import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuniorAccountTest {

    @Test
    void getAge() {
        JuniorAccount account = new JuniorAccount("123456", "John Smith Jr.", 100.0, 15);
        assertEquals(15,account.getAge());
    }

    @Test
    void getWithdrawLimit() {
        JuniorAccount account = new JuniorAccount("123456", "John Smith Jr.", 100.0, 15);
        assertEquals(100,account.getWithdrawLimit());
    }

    @Test
    void withdraw() {
        JuniorAccount account = new JuniorAccount("123456", "John Smith Jr.", 100.0, 15);
        account.withdraw(200);
    }
}