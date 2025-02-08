package PilotSMS;

class InvalidMajorException extends Exception {
    public InvalidMajorException(String message) {
        super(message);
    }
}


public class MajorValidationException {
    public static void validateMajor(String sMajor) throws InvalidMajorException {
        sMajor = sMajor.trim();
        if (!sMajor.equals("Art") & !sMajor.equals("Economics") & !sMajor.equals("Math")) {
            throw new InvalidMajorException("must be Art, Economics or Math");
        }
    }
}
