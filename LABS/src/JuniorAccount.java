public class JuniorAccount extends BankAccount {
    public int age;
    public int withdrawLimit;

    public JuniorAccount(String accountNumber, String accountName, double balance, int age) {
        super(accountNumber, accountName, balance);
        if (age >= 16) {
            throw new IllegalArgumentException("Junior account holder must be under 16 years old.");
        }
        this.age = age;
        this.withdrawLimit = 100;
    }

    public int getAge() {
        return age;
    }

    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(!suspended){
            if (amount > withdrawLimit) {
                System.out.println("Withdrawal limit exceeded. Maximum withdrawal amount is " + withdrawLimit + " Yuan/day.");
            } else if (amount > getBalance()) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
            }
        }else{
            System.out.println("Cannot deposit. Account is suspended.");
        }
    }

}

