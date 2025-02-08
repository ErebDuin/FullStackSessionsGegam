package SMS;

import SMS.custom_exceptions.IllegalAgeException;
import SMS.custom_exceptions.IllegalEmailException;
import SMS.custom_exceptions.IllegalNameException;

import java.util.Scanner;

import static SMS.StudentParameterValidation.*;
/**
 * Abstract class representing a student.
 */
public abstract class Student {
    Scanner scanner = new Scanner(System.in);

    private int id;
    private String eMail;
    private String firstName;
    private String lastName;
    private int age;
    public Major major;

    private static int nextId = 1;
    private static int studentCount = 0;

    /**
     * Constructs a new Student with the specified details.
     *
     * @param eMail     the email of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public Student(String eMail, String firstName, String lastName, int age, Major major) {
        this.id = nextId++;
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        studentCount++;
    }

    /**
     * Constructs a new Student with the specified details.
     *
     * @param id        the ID of the student
     * @param eMail     the email of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public Student(int id, String eMail, String firstName, String lastName, int age, Major major) {
        this.id = id;
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        studentCount++;
    }

    /**
     * Returns the ID of the student.
     *
     * @return the ID of the student
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the email of the student.
     *
     * @return the email of the student
     */
    public String getEMail() {
        return eMail;
    }

    /**
     * Sets the email of the student.
     *
     * @param eMail the email to set
     */
    public void setEmail(String eMail) {
        boolean validEmail = false;
        while (!validEmail) {
            try {
                validateEmail(eMail);
                this.eMail = eMail;
                validEmail = true;
            } catch (IllegalEmailException e) {
                System.out.println(e.getMessage());
                eMail = scanner.nextLine();
            }
        }
    }

    /**
     * Returns the first name of the student.
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        boolean validName = false;
        while (!validName) {
            try {
                validateName(firstName);
                this.firstName = firstName;
                validName = true;
            } catch (IllegalNameException e) {
                System.out.println(e.getMessage());
                firstName = scanner.next();
            }
        }
    }

    /**
     * Returns the last name of the student.
     *
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        boolean validName = false;
        while (!validName) {
            try {
                validateName(lastName);
                this.lastName = lastName;
                validName = true;
            } catch (IllegalNameException e) {
                System.out.println(e.getMessage());
                lastName = scanner.next();
            }
        }
    }

    /**
     * Returns the age of the student.
     *
     * @return the age of the student
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        boolean validAge = false;
        while (!validAge) {
            try {
                validateAge(age);
                this.age = age;
                validAge = true;
            } catch (IllegalAgeException e) {
                System.out.println(e.getMessage());
                age = scanner.nextInt();
            }
        }
    }

    /**
     * Returns the major of the student.
     *
     * @return the major of the student
     */
    public Major getMajor() {
        return major;
    }

    /**
     * Sets the major of the student.
     *
     * @param majorStr the major to set
     */
    public void setMajor(String majorStr) {
        boolean validMajor = false;
        while (!validMajor) {
            try {
                this.major = Major.valueOf(majorStr.toUpperCase());
                validMajor = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid major, please enter a valid major (e.g., ART, ECONOMICS, MATH):");
                majorStr = scanner.nextLine();
            }
        }
    }

    /**
     * Sets the next ID for the student.
     *
     * @param nextId the next ID to set
     */
    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    /**
     * Prints the details of the student.
     */
    public abstract void print();

    /**
     * Returns a string representation of the student.
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return String.format("ID: %d, Email: %s, First Name: %s, Last Name: %s, Age: %d, Major: %s", id, eMail, firstName, lastName, age, major);
    }
}