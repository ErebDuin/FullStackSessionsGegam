package PilotSMS;

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}


public class NameValidationException {
    public static void validateName(String name) throws InvalidNameException {
        name = name.trim();
        if (name.length() < 3 || name.length() > 15) {
            throw new InvalidNameException("must be between 3 and 15 characters");
        }
    }
}