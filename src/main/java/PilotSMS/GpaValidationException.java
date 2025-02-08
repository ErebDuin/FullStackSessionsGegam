package PilotSMS;

class InvalidGpaException extends Exception {
    public InvalidGpaException(String message) {
        super(message);
    }
}


public class GpaValidationException {
    public static void validateGpa(double gpa) throws InvalidGpaException {
        if (gpa < 0 || gpa > 4) {
            throw new InvalidGpaException("GPA must be between 0 and 4.0");
        }
    }
}
