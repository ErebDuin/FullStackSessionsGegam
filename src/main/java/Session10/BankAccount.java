package Session10;

public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    // deposit (>0)
    public void deposit(double amount) {
        if (amount <= 0) {
            setBalance(amount);
            System.out.println("Deposited: " + amount);
        }
        else {
            System.out.println("Amount must be greater than 0");
        }
    }

    // withdraw (<= balance)
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Amount must be less than or equal to balance");
        }
    }

    public static void main(String[] args) {

    }
}
