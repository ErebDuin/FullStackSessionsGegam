package SMS;

import java.util.InputMismatchException;
import static SMS.ageValidationException.validateAge;
import static SMS.nameValidationException.validateName;
import static SMS.majorValidationException.validateMajor;


public class Student {
    private static int studentCount = 0;
    private int studentId;
    private String firstName;
    private String lastName;
    private int studentAge;
    private String studentMajor;

    public Student() {
    }



    public static void setStudentCount(int studentCount) {
        Student.studentCount = studentCount;
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
            String name = fName;
            validateName(name);
            this.firstName = fName;
        }
        catch (InvalidNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        }

    }

    public void setStudentLastName(String lName) {
        try {
            String name = lName;
            validateName(name);
            this.lastName = lName;
        }
        catch (InvalidNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        }
    }

    public void setStudentAge(int age) {
        try {
            validateAge(age);
            this.studentAge = age;
        }
        catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input: must be a number");
        }
    }

    public void setStudentMajor(String sMajor) {
        try {
            validateMajor(sMajor);
            this.studentMajor = sMajor;
        }
        catch (InvalidMajorException e) {
            System.out.println("Invalid major: " + e.getMessage());
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

    @Override
    public String toString() {
        //return "Student ID: " + studentId + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + studentAge;
        return String.format("\nStudent ID: %d\nFirst Name: %s\nLast Name: %s\nAge: %d\nMajor: %s\n", studentId, firstName, lastName, studentAge, studentMajor);
    }
}