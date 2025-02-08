package SMS.menu;
import SMS.*;
import java.util.Scanner;

public class DeleteStudent {
    private StudentMaintenance studentMaintenance;
    private Scanner scanner;

    public DeleteStudent(StudentMaintenance studentMaintenance, Scanner scanner) {
        this.studentMaintenance = studentMaintenance;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student ID to delete or 'e' to return: ");
        String userInput = scanner.nextLine();

        int id;
        if (userInput.equals("e")) {
            return;
        } else {
            id = Integer.parseInt(userInput);
        }

        Student studentToRemove = null;
        for (Student student : studentMaintenance.getStudents()) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentMaintenance.getStudents().remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
