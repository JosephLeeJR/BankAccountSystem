import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void openAccount() {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("123456", "John Smith", 1000.0);
        CurrentAccount account2 = new CurrentAccount("654321", "Jane Doe", 1000.0);
        JuniorAccount account3= new JuniorAccount("114514","Minghao",1000,11);
        bank.openAccount(account1);
        bank.openAccount(account2);
        bank.openAccount(account3);
        System.out.println(bank.accounts);
    }

    @Test
    void closeAccount() {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("123456", "John Smith", 1000.0);
        CurrentAccount account2 = new CurrentAccount("654321", "Jane Doe", 1000.0);
        bank.openAccount(account1);
        bank.openAccount(account2);
        System.out.println(bank.accounts);
        bank.closeAccount(account2);
        System.out.println(bank.accounts);
    }

    @Test
    void infoAboutAccounts() {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount("123456", "John Smith", 1000.0);
        CurrentAccount account2 = new CurrentAccount("654321", "Jane Doe", 1000.0);
        bank.openAccount(account1);
        bank.openAccount(account2);
        bank.infoAboutAccounts();
    }
}