package Session12.BankingSystem;

public class CheckingAccount extends BankAccount implements Transaction {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double accountBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, accountBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw (double amount) {
        if (amount > 0 && (getAccountBalance() + overdraftLimit - amount >= 0)) {
            super.withdraw(amount);
        } else {
            System.out.println("Invalid withdraw amount");
        }
    }

    @Override
    public void displayAccountData() {
        System.out.println("Checking Account Number: " + getAccountNumber());
        System.out.println("Account Holder Name: " + getAccountHolderName());
        System.out.println("Checking Account Balance: " + getAccountBalance());
        System.out.println("Overdraft: " + overdraftLimit);
    }
}
