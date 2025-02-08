package PilotSMS;

import java.util.Scanner;
import static PilotSMS.AgeValidationException.validateAge;
import static PilotSMS.NameValidationException.validateName;
import static PilotSMS.MajorValidationException.validateMajor;
import static PilotSMS.SmsLogger.log;


abstract class Student {
    Scanner scanner = new Scanner(System.in);

    private static int studentCount = 0;
    private int studentId;
    private String firstName;
    private String lastName;
    private int studentAge;
    private String studentMajor;

    public Student() {
    }


    public static int idGenerator() {
        return (int) (Math.random() * 1000);
    }

    public void setStudentId(int id) {
        studentCount++;
        this.studentId = idGenerator();
    }

    public void setStudentFirstName (String fName) {
        try {
            validateName(fName);
            this.firstName = fName;
        } catch (InvalidNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
            System.exit(0);
        }
    }

    public void setStudentLastName (String lName) {
        try {
            validateName(lName);
            this.lastName = lName;
        }
        catch (InvalidNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
            System.exit(0);
        }
    }

    public void setStudentAge (int age) {
        boolean validAge = false;
        while (!validAge) {
            try {
                validateAge(age);
                this.studentAge = age;
                validAge = true;
            } catch (InvalidAgeException e) {
                System.out.println("Invalid age: " + e.getMessage());
                log(e.getMessage());
                scanner.nextLine();
            }
        }
    }

    public void setStudentMajor (String sMajor) {
        try {
            validateMajor(sMajor);
            this.studentMajor = sMajor;
        }
        catch (InvalidMajorException e) {
            System.out.println("Invalid major: " + e.getMessage());
            log(e.getMessage());
            System.exit(0);
        }
    }


    public static int getStudentCount() {
        return studentCount;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getStudentFirstName() {
        return firstName;
    }
    public String getStudentLastName() {
        return lastName;
    }
    public int getStudentAge() {
        return studentAge;
    }
    public String getStudentMajor() {
        return studentMajor;
    }

    public void displayStudentData() {
        System.out.println("Student ID: " + getStudentId());
        System.out.println("First Name: " + getStudentFirstName());
        System.out.println("Last Name: " + getStudentLastName());
        System.out.println("Age: " + getStudentAge());
        System.out.println("Major: " + getStudentMajor());
    }
}