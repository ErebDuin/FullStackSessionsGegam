package SMS.custom_exceptions;

/**
 * Exception thrown when an illegal Email value is encountered.
 */
public class IllegalEmailException extends Exception {
    /**
     * Constructs a new IllegalEmailException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalEmailException(String message) {
        super(message);
    }
}
