package SMS;

class InvalidMajorException extends Exception {
    public InvalidMajorException(String message) {
        super(message);
    }
}

public class majorValidationException {
    public static void validateMajor(String sMajor) throws InvalidMajorException {
        sMajor.trim().replaceAll("\\s", "");
        if (!sMajor.equals("Art") || !sMajor.equals("Economics") || !sMajor.equals("Math")) {
            throw new InvalidMajorException("must be Art, Economics or Math");
        }
    }
}
