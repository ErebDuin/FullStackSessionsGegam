package Session6;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMenuWithUniqueId {

    static class Student {
        int studentId;
        String firstName;
        String lastName;
        int studentAge;

        Student(int id, String fName, String lName, int age) {
            this.studentId = id;
            this.firstName = fName;
            this.lastName = lName;
            this.studentAge = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("======== Student Menu ========");
            System.out.println("1. Add Student Details");
            System.out.println("2. View Student Details");
            System.out.println("3. Reset Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                                               // Add student details
                    while (true) {
                        System.out.print("\nEnter student ID: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();

                                                                // Check if the student ID is unique
                        boolean isUnique = true;
                        for (Student s : students) {
                            if (s.studentId == studentId) {
                                isUnique = false;
                                break;
                            }
                        }

                        if (!isUnique) {
                            System.out.println("\nStudent ID already exists. Please enter a unique ID.");
                            continue;
                        }

                        System.out.print("Enter first name: ");
                        String firstName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                        while (true) {                                                               // Ask first name until it is between 3 and 15 characters
                            if (firstName.length() < 3 || firstName.length() > 15) {
                                System.out.println("\nFirst name should be between 3 and 15 characters\n");
                                System.out.print("Enter first name: ");
                                firstName = scanner.next().trim();
                            } else {
                                break;
                            }
                        }

                        System.out.print("Enter last name: ");
                        String lastName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                        while (true) {                                                                     // Ask last name until it is between 3 and 15 characters
                            if (lastName.length() < 3 || lastName.length() > 15) {
                                System.out.println("\nLast name should be between 3 and 15 characters\n");
                                System.out.print("Enter last name: ");
                                lastName = scanner.next().trim();
                            } else {
                                break;
                            }
                        }

                        System.out.print("Enter student age: ");
                        int studentAge = scanner.nextInt();
                        scanner.nextLine();

                        Student studentCreated = new Student(studentId, firstName, lastName, studentAge);

                        students.add(studentCreated);

                        System.out.println("\nInformation added successfully");
                        System.out.println();
                        break;
                    }
                    break;
                case 2:                                                      // View student details
                    if (students.isEmpty()) {
                        System.out.println("\nNo student details available.\n");
                    } else {
                        for (Student s : students) {
                            System.out.println("\nStudent ID: " + s.studentId);
                            System.out.println("First Name: " + s.firstName);
                            System.out.println("Last Name: " + s.lastName);
                            System.out.println("Student Age: " + s.studentAge);
                            System.out.println();
                        }
                    }
                    break;
                case 3:                                                       // Reset student details
                    System.out.print("\nEnter student id to delete student details: ");
                    int studentIdToDelete = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).studentId == studentIdToDelete) {
                            students.remove(i);
                            found = true;
                            System.out.println("\nStudent details successfully deleted!\n");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nStudent ID not found.\n");
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