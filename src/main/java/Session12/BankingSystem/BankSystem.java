package Session12.BankingSystem;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Choose an account: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial account balance: ");
        double accountBalance = scanner.nextDouble();

        if (choice == 1) {
            System.out.println("Enter overdraft limit: ");
            double overdraftLimit = scanner.nextDouble();
            account = new CheckingAccount(accountNumber, accountHolderName, accountBalance, overdraftLimit);
        } else if (choice == 2) {
//            account = new SavingsAccount(accountNumber, accountHolderName, accountBalance);
        } else {
            System.out.println("Invalid choice");
            System.exit(0);
        }

        while (true) {
            System.out.println("Choose an option");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Balance");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Account balance: " + account.getAccountBalance());
                    break;
                case 4:
                    account.displayAccountData();
                    break;
                case 5:
                    // Calculate interest for savings account
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    } else {
                        System.out.println("Invalid option.");
                        break;
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
