package Session2;

import java.util.Scanner;

public class StudentInput {
    public static void main(String[] args) {
        Student student = new Student();
        student.inputDetails();
        student.displayStudentDetails();

    }
}

class Student {
    int studentId;
    String firstName;
    String lastName;
    int age;

    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your student identifier: ");
        studentId = scanner.nextInt();
        System.out.println("Enter your first name: ");
        firstName = scanner.next();
        System.out.println("Enter your last name: ");
        lastName = scanner.next();
        System.out.println("Enter your age: ");
        age = scanner.nextInt();
        scanner.close();
    }

    public void displayStudentDetails() {
        System.out.println("\n ===== Student details =====");
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);

    }
}