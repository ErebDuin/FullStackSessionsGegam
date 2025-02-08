package SMS.menu;

import SMS.*;
import SMS.custom_exceptions.IllegalGpaException;

import java.util.Arrays;
import java.util.Scanner;

public class AddStudent {
    private StudentMaintenance studentMaintenance;
    private Scanner scanner;

    public AddStudent(StudentMaintenance studentMaintenance, Scanner scanner) {
        this.studentMaintenance = studentMaintenance;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("\n--- Add Student ---");
        System.out.println("1. Undergraduate");
        System.out.println("2. Graduate");
        System.out.print("Enter student type or 'e' to return: ");
        String userInput = scanner.nextLine();

        int type;
        if (userInput.equals("e")) {
            return;
        } else {
            type = Integer.parseInt(userInput);
        }

        System.out.print("Enter your email: ");
        String eMail = scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter major " + Arrays.toString(Major.values()) + ": ");
        String majorStr = scanner.nextLine();

        Student student;
        if (type == 1) {
            student = new UndergradStudent(studentMaintenance.getStudents().size(), null, null, null, 0, null);
                                            student.setEmail(eMail);
                                            student.setFirstName(firstName);
                                            student.setLastName(lastName);
                                            student.setAge(age);
                                            student.setMajor(majorStr);
        } else if (type == 2) {
            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            GraduateStudent gradStudent = new GraduateStudent(studentMaintenance.getStudents().size() + 1, null, null, null, 0, null);
                                                                gradStudent.setEmail(eMail);
                                                                gradStudent.setFirstName(firstName);
                                                                gradStudent.setLastName(lastName);
                                                                gradStudent.setAge(age);
                                                                gradStudent.setMajor(majorStr);
            try {
                gradStudent.setGPA(gpa);
            } catch (IllegalGpaException e) {
                System.out.println("Invalid GPA: " + e.getMessage());
                return;
            }
            student = gradStudent;
        } else {
            System.out.println("Invalid student type.");
            return;
        }

        studentMaintenance.addStudent(student);
        System.out.println("Student added successfully.");
    }
}
