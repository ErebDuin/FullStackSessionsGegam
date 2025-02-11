package SMS.menu;

import SMS.StudentHttpServer;
import SMS.StudentMaintenance;

import java.util.Scanner;


public class MainMenu {
    private final StudentMaintenance studentMaintenance;
    private final Scanner scanner;
    private final StudentHttpServer server;

    public MainMenu(StudentMaintenance studentMaintenance, Scanner scanner, StudentHttpServer server) {
        this.studentMaintenance = studentMaintenance;
        this.scanner = scanner;
        this.server = server;
    }


    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("Students count: " + studentMaintenance.getStudents().size());
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Edit student");
            System.out.println("4. Delete Student");
            System.out.println("5. Graduate a student");
            System.out.println("6. Search Student");
            System.out.println("0. Save and Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new AddStudent(studentMaintenance, scanner).execute();
                    break;
                case 2:
                    new ViewStudent(studentMaintenance, scanner).execute();
                    break;
                case 3:
                    new EditStudent(studentMaintenance, scanner).execute();
                    break;
                case 4:
                    new DeleteStudent(studentMaintenance, scanner).execute();
                    break;
                case 5:
                    new StudentGraduationHandler(studentMaintenance, scanner).execute();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    studentMaintenance.saveStudents();
                    server.stop();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}