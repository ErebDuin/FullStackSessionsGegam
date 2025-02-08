package SMS.menu;
import SMS.*;
import SMS.custom_exceptions.IllegalGpaException;
import java.util.Scanner;


public class EditStudent {
    private StudentMaintenance studentMaintenance;
    private Scanner scanner;

    public EditStudent(StudentMaintenance studentMaintenance, Scanner scanner) {
        this.studentMaintenance = studentMaintenance;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student ID to edit or 'e' to return: ");
        String userInput = scanner.nextLine();

        int id;
        if (userInput.equals("e")) {
            return;
        } else {
            id = Integer.parseInt(userInput);
        }

        Student studentToEdit = null;
        for (Student student : studentMaintenance.getStudents()) {
            if (student.getId() == id) {
                studentToEdit = student;
                break;
            }
        }

        if (studentToEdit == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter new email (leave blank to keep current): ");
        String eMail = scanner.nextLine();
        if (!eMail.isEmpty()) {
            studentToEdit.setEmail(eMail);
        }

        System.out.print("Enter new first name (leave blank to keep current): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            studentToEdit.setFirstName(firstName);
        }

        System.out.print("Enter new last name (leave blank to keep current): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            studentToEdit.setLastName(lastName);
        }

        System.out.print("Enter new age (leave blank to keep current): ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) {
            int age = Integer.parseInt(ageStr);
            studentToEdit.setAge(age);
        }

        System.out.print("Enter new major (leave blank to keep current): ");
        String majorStr = scanner.nextLine();
        if (!majorStr.isEmpty()) {
            Major major = Major.valueOf(majorStr.toUpperCase());
            studentToEdit.major = major;
        }

        if (studentToEdit instanceof GraduateStudent) {
            System.out.print("Enter new GPA (leave blank to keep current): ");
            String gpaStr = scanner.nextLine();
            if (!gpaStr.isEmpty()) {
                try {
                    double gpa = Double.parseDouble(gpaStr);
                    ((GraduateStudent) studentToEdit).setGPA(gpa);
                } catch (IllegalGpaException e) {
                    System.out.println("Invalid GPA: " + e.getMessage());
                }
            }
        }
        System.out.println("Student details updated successfully.");
    }
}
