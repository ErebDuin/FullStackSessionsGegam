package SMS;

/**
 * Class representing an undergraduate student.
 */
public class UndergradStudent extends Student implements Printable {

    /**
     * Constructs a new UndergradStudent with the specified details.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public UndergradStudent(String eMail, String firstName, String lastName, int age, Major major) {
        super(eMail, firstName, lastName, age, major);
    }

    /**
     * Constructs a new UndergradStudent with the specified details.
     *
     * @param id        the ID of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public UndergradStudent(int id, String eMail, String firstName, String lastName, int age, Major major) {
        super(id, eMail, firstName, lastName, age, major);
    }

    /**
     * Prints the details of the undergraduate student.
     */
    @Override
    public void print() {
        System.out.format("| %-15s | %-10d | %-25s | %-15s | %-15s | %-10d | %-15s | %-15s |%n",
                "Undergraduate", getId(), getEMail(), getFirstName(), getLastName(), getAge(), major, "");
        System.out.format("+-----------------+------------+---------------------------+-----------------+-----------------+------------+-----------------+-----------------+%n");
    }
}