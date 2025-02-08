package SMS.menu;

import SMS.GraduationProcess;
import SMS.StudentMaintenance;

import java.util.Scanner;

public class StudentGraduationHandler {
    private final StudentMaintenance studentMaintenance;
    private final Scanner scanner;

    public StudentGraduationHandler(StudentMaintenance studentToGraduate, Scanner scanner) {
        this.studentMaintenance = studentToGraduate;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("Enter the student ID to graduate: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        if (GraduationProcess.graduateStudentByIdAndGpa(id, gpa, studentMaintenance) != null) {
            System.out.println("Student graduated.");
        } else {
            System.out.println("Student not found or already graduated.");
        }
    }
}
