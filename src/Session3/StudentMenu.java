package Session3;

import java.util.Scanner;

public class StudentMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentId = 0;
        String firstName = "";
        String lastName = "";
        int studentAge  = 0;

        while (true) {
            System.out.println("======== Student Menu ========");
            System.out.println("1. Add Student Details");
            System.out.println("2. View Student Details");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    studentId = scanner.nextInt();

                    System.out.println("Enter first name: ");
                    firstName = scanner.next();

                    System.out.println("Enter last name: ");
                    lastName = scanner.next();

                    System.out.println("Enter student age: ");
                    studentAge = scanner.nextInt();

                    System.out.println("Information added successfully");
                    break;
                case 2:
                    System.out.println("Student ID: " + studentId);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Student Age: " + studentAge);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not supported option");
                    scanner.next();
            }
        }
    }
}
