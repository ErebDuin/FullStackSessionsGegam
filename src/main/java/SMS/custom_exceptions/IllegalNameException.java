package SMS.custom_exceptions;

/**
 * Exception thrown when an illegal Name value is encountered.
 */
public class IllegalNameException extends Exception {
    /**
     * Constructs a new IllegalNameException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalNameException(String message) {
        super(message);
    }
}
