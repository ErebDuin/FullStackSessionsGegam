package Session12.BankingSystem;

public class SavingsAccount extends BankAccount implements Transaction {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double accountBalance, double interestRate) {
        super(accountNumber, accountHolderName, accountBalance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        // Calculate interest and deposit it
        double interest = getAccountBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: $" + interest);
    }


    @Override
    public void displayAccountData() {
        System.out.println("Checking Account Number: " + getAccountNumber());
        System.out.println("Account Holder Name: " + getAccountHolderName());
        System.out.println("Checking Account Balance: " + getAccountBalance());
        System.out.println("Interest rate: " + interestRate);
    }
}
