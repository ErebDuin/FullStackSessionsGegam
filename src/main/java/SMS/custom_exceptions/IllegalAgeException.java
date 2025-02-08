package SMS.custom_exceptions;

/**
 * Exception thrown when an illegal Age value is encountered.
 */
public class IllegalAgeException extends Exception {
    /**
     * Constructs a new IllegalAgeException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalAgeException(String message) {
        super(message);
    }
}
