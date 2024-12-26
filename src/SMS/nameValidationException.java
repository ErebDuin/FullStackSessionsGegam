package SMS;

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class nameValidationException {
    public static void validateName(String name) throws InvalidNameException {
        name.trim().replaceAll("\\s", "");
        if (name.length() < 3 || name.length() > 15) {
            throw new InvalidNameException("must be between 3 and 15 characters");
        }
    }
}