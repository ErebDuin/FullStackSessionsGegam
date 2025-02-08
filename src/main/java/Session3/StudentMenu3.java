package Session3;

import java.util.Scanner;

public class StudentMenu3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentId = 0;
        String firstName = "";
        String lastName = "";
        byte studentAge  = 0;

        while (true) {
            System.out.println("======== Student Menu ========");
            System.out.println("1. Add Student Details");
            System.out.println("2. View Student Details");
            System.out.println("3. Reset Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            byte choice = scanner.nextByte();

            switch (choice) {
                case 1:                                               // Add student details
                    System.out.print("\nEnter student ID: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter first name: ");
                    firstName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                    while (true) {  // Ask first name until it is between 3 and 15 characters
                        if (firstName.length() < 3 || firstName.length() > 15) {
                            System.out.println("\nFirst name should be between 3 and 15 characters\n");
                            System.out.print("Enter first name: ");
                            firstName = scanner.next().trim();
                        }
                        else
                            break;
                    }

                    System.out.print("Enter last name: ");
                    lastName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                    while (true) {                                                              // Ask last name until it is between 3 and 15 characters
                        if (lastName.length() < 3 || lastName.length() > 15) {
                            System.out.println("\nLast name should be between 3 and 15 characters\n");
                            System.out.print("Enter last name: ");
                            lastName = scanner.next().trim();
                        }
                        else
                            break;
                    }

                    System.out.print("Enter student age: ");
                    studentAge = scanner.nextByte();

                    System.out.println("Information added successfully");
                    System.out.println();
                    break;
                case 2:                                                      // View student details
                    System.out.println();
                    System.out.println("Student ID: " + studentId);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Student Age: " + studentAge);
                    System.out.println();
                    break;
                case 3:                                                       // Reset student details
                    studentId = 0;
                    firstName = "";
                    lastName = "";
                    studentAge = 0;
                    System.out.println("\nStudent details successfully reset!\n");
                    break;
                case 4:                                                       // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:                                                      // Invalid option
                    System.out.print("\nNot supported sption,\nPlease try again!\n\n");
            }
        }
    }
}
