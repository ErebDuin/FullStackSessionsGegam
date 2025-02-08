package SMS.menu;
import SMS.*;
import SMS.custom_comparators.*;

import java.util.Scanner;


public class ViewStudent {
    private final StudentMaintenance studentMaintenance;
    private final Scanner scanner;

    public ViewStudent(StudentMaintenance studentMaintenance, Scanner scanner) {
        this.studentMaintenance = studentMaintenance;
        this.scanner = scanner;
    }

    public void execute() {
        if (studentMaintenance.getStudents().isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("View students by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Major");
        System.out.print("Enter your choice or 'e' to return: ");
        String userInput = scanner.nextLine();

        int choice;
        if (userInput.equals("e")) {
            return;
        } else {
            choice = Integer.parseInt(userInput);
        }

        switch (choice) {
            case 1:
                studentMaintenance.getStudents().sort(new StudentIdComparator());
                break;
            case 2:
                studentMaintenance.getStudents().sort(new StudentNameComparator());
                break;
            case 3:
                studentMaintenance.getStudents().sort(new StudentMajorComparator());
                break;
            default:
                System.out.println("Invalid choice. Displaying unsorted list.");
        }

        // Print table header
        System.out.format("+-----------------+------------+---------------------------+-----------------+-----------------+------------+-----------------+-----------------+%n");
        System.out.format("| %-15s | %-10s | %-25s | %-15s | %-15s | %-10s | %-15s | %-15s |%n", "TYPE", "ID", "EMAIL", "FIRST NAME", "LAST NAME", "AGE", "MAJOR", "GPA");
        System.out.format("+-----------------+------------+---------------------------+-----------------+-----------------+------------+-----------------+-----------------+%n");

        // Print each student
        for (Student student : studentMaintenance.getStudents()) {
            student.print();
        }
    }
}
