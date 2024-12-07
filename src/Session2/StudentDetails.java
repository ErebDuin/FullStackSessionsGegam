package Session2;

import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        // Student identifier
        // Student firstName
        // Student lastName
        // Student age

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your student identifier: ");
        int studentId = scanner.nextInt();
        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("\n ===== Student details =====");
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);


    }
}
