package Session4;

import java.util.Scanner;

public class MultiplicationTable {
    static class Student {
        int studentId;
        String firstName;
        String lastName;
        byte studentAge;

        Student(int id, String fName, String lName, byte age) {
            this.studentId = id;
            this.firstName = fName;
            this.lastName = lName;
            this.studentAge = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[5];
        byte studentCount = 0;
        Student student = null;
        String firstName, lastName;
        byte studentAge;

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
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter first name: ");
                    firstName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                    while (true) {  // Ask first name until it is between 3 and 15 characters
                        if (firstName.length() < 3 || firstName.length() > 15) {
                            System.out.println("\nFirst name should be between 3 and 15 characters\n");
                            System.out.print("Enter first name: ");
                            firstName = scanner.next().trim();
                        } else {
                            break;
                        }
                    }

                    System.out.print("Enter last name: ");
                    lastName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                    while (true) {                                                              // Ask last name until it is between 3 and 15 characters
                        if (lastName.length() < 3 || lastName.length() > 15) {
                            System.out.println("\nLast name should be between 3 and 15 characters\n");
                            System.out.print("Enter last name: ");
                            lastName = scanner.next().trim();
                        } else {
                            break;
                        }
                    }

                    System.out.print("Enter student age: ");
                    studentAge = scanner.nextByte();

                    student = new Student(studentId, firstName, lastName, studentAge);

                    students[studentCount] = student;
                    studentCount++;

                    System.out.println("Information added successfully");
                    System.out.println();
                    break;
                case 2:                                                      // View student details
                    if (student != null) {
                        System.out.println();
                        System.out.println("Student ID: " + student.studentId);
                        System.out.println("First Name: " + student.firstName);
                        System.out.println("Last Name: " + student.lastName);
                        System.out.println("Student Age: " + student.studentAge);
                        System.out.println();
                    } else {
                        System.out.println("No student details available.");
                    }
                    break;
                case 3:                                                       // Reset student details
                    if (student != null) {
                        student.studentId = 0;
                        student.firstName = "";
                        student.lastName = "";
                        student.studentAge = 0;
                        System.out.println("\nStudent details successfully reset!\n");
                    } else {
                        System.out.println("No student details available to reset.");
                    }
                    break;
                case 4:                                                       // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:                                                      // Invalid option
                    System.out.print("\nNot supported option,\nPlease try again!\n\n");
            }
        }
    }
}