package PilotSMS;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


public class AgeValidationException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 100) {
            throw new InvalidAgeException("age must be between 18 and 100");
        }
    }
}