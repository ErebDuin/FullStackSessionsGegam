package SMS;

import SMS.custom_exceptions.IllegalGpaException;

import java.util.Scanner;

/**
 * Represents a graduate student.
 */
public class GraduateStudent extends Student implements Printable {
    Scanner Scanner = new Scanner(System.in);
    private double GPA;

    /**
     * Constructs a GraduateStudent from save file with the specified details.
     *
     * @param eMail     the email of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public GraduateStudent(String eMail, String firstName, String lastName, int age, Major major) {
        super(eMail, firstName, lastName, age, major);
    }

    /**
     * Constructs a new GraduateStudent with the specified details.
     *
     * @param id        the ID of the student
     * @param eMail     the email of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public GraduateStudent(int id, String eMail, String firstName, String lastName, int age, Major major) {
        super(id, eMail, firstName, lastName, age, major);
    }

    /**
     * Returns the GPA of the student.
     *
     * @return the GPA of the student
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Sets the GPA of the student.
     *
     * @param GPA the GPA to set
     * @throws IllegalGpaException if the GPA is not between 0 and 4
     */
    public void setGPA(double GPA) throws IllegalGpaException {
        boolean validGpa = false;
        while (!validGpa) {
            try {
                validateGpa(GPA);
                this.GPA = GPA;
                validGpa = true;
            } catch (IllegalGpaException e) {
                System.out.println(e.getMessage());
                GPA = Scanner.nextDouble();
            }
        }
    }

    /**
     * Validates the specified GPA value.
     *
     * @param gpa the Age value to validate
     * @throws IllegalGpaException if the Age value is invalid
     */
    public static void validateGpa(double gpa) throws IllegalGpaException {
        if (!String.valueOf(gpa).matches ("^[0-4]\\.\\d\\d$")) {
            throw new IllegalGpaException("GPA must be between 0.00 and 4.00");
        }
    }


    /**
     * Prints the details of the graduate student in a table format.
     */
    @Override
    public void print() {
        System.out.format("| %-15s | %-10d | %-25s | %-15s | %-15s | %-10d | %-15s | %-15.2f |%n",
                "Graduate", getId(), getEMail(), getFirstName(), getLastName(), getAge(), major, getGPA());
        System.out.format("+-----------------+------------+---------------------------+-----------------+-----------------+------------+-----------------+-----------------+%n");
    }
}