package Session3;

import java.util.Scanner;

public class StudentAgeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your age: ");
            int age = scanner.nextInt();
            if (age >= 18) {
                System.out.println("You are eligible to vote");
            } else {
                System.out.println("You are not eligible to vote");
            }
            System.out.println("Do you want to continue? (yes/no)");
            String choice = scanner.next();
            if (choice.equals("no")) {
                break;
            }
        }
    }
}
