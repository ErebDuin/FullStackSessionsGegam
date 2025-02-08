package Session18.SMS;

import java.util.Scanner;
import static Session18.SMS.StudentValidator.*;


/**
 * The abstract Student class represents a student with common attributes and methods.
 * It implements the Printable interface to allow printing student details.
 */
public abstract class Student implements Printable {
    Scanner scanner = new Scanner(System.in);

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private int age;
    protected Major major;

    private static int nextId = 1;

    /**
     * Constructs a Student with the specified details.
     *
     * @param id the student's ID
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param age the student's age
     * @param major the student's major
     */
    public Student(int id, String email, String firstName, String lastName, int age, Major major) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
    }

    /**
     * Gets the student's ID.
     *
     * @return the student's ID
     */
    public int getId() { return id; }

    /**
     * Returns the email of the student.
     *
     * @return the email of the student
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the student's first name.
     *
     * @return the student's first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Gets the student's last name.
     *
     * @return the student's last name
     */
    public String getLastName() { return lastName; }

    /**
     * Gets the student's age.
     *
     * @return the student's age
     */
    public int getAge() { return age; }

    /**
     * Gets the student's major.
     *
     * @return the student's major
     */
    public Major getMajor() { return major; }

    /**
     * Sets the email of the student.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        boolean validEmail = false;
        while (!validEmail) {
            try {
                validateEmail18(email);
                this.email = email;
                validEmail = true;
            } catch (IllegalEmailException e) {
                System.out.println(e.getMessage());
                email = scanner.nextLine();
            }
        }
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName) {
        boolean validFirstName = false;
        while (!validFirstName) {
            try {
                validateName18(firstName);
                this.firstName = firstName;;
                validFirstName = true;
            } catch (IllegalNameException e) {
                System.out.println(e.getMessage());
                firstName = scanner.nextLine();
            }
        }
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the student's last name
     */
    public void setLastName(String lastName) {
        boolean validLastName = false;
        while (!validLastName) {
            try {
                validateName18(lastName);
                this.lastName = lastName;
                ;
                validLastName = true;
            } catch (IllegalNameException e) {
                System.out.println(e.getMessage());
                lastName = scanner.nextLine();
            }
        }
    }

    /**
     * Sets the student's age.
     *
     * @param age the student's age
     */
    public void setAge(int age) {
        boolean validAge = false;
        while (!validAge) {
            try {
                validateAge18(age);
                this.age = age;
                validAge = true;
            } catch (IllegalAgeException e) {
                System.out.println(e.getMessage());
                age = scanner.nextInt();
            }
        }
    }

    /**
     * Sets the student's major.
     *
     * @param major the student's major
     */
    public void setMajor(Major major) {
        try {
            validateMajor18(major.toString());
            this.major = major;
        } catch (IllegalArgumentException | IllegalMajorException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets the next ID to be assigned to a student.
     *
     * @param nextId the next ID to be assigned
     */
    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    /**
     * Prints the details of the student.
     */
    @Override
    public abstract void print();
}