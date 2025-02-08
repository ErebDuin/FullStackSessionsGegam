package Session18.SMS;

public final class StudentValidator {

    /**
     * Validates the specified Name value.
     *
     * @param name the Name value to validate
     * @throws IllegalNameException if the Email value is invalid
     */
    public static void validateName18(String name) throws IllegalNameException {
        if (!name.matches("^\\w{2,15}$")) {
            throw new IllegalNameException("Invalid name: " + name);
        }
    }

    /**
     * Validates the specified Age value.
     *
     * @param age the Age value to validate
     * @throws IllegalAgeException if the Age value is invalid
     */
    public static void validateAge18(int age) throws IllegalAgeException {
        if (!String.valueOf(age).matches ("^(1[8-9]|[2-9][0-9]|1[0-4][0-9]|150)$")) {
            throw new IllegalAgeException("age must be between 18 and 150");
        }
    }

    /**
     * Validates the specified Email value.
     *
     * @param email the Email value to validate
     * @throws IllegalEmailException if the Email value is invalid
     */
    public static void validateEmail18(String email) throws IllegalEmailException {
        if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]{2,15}$")) {
            throw new IllegalEmailException("Invalid email: " + email);
        }
    }


    /**
     * Validates the specified Major value.
     *
     * @param major the Email value to validate
     * @throws IllegalMajorException if the Email value is invalid
     */
    public static void validateMajor18(String major) throws IllegalMajorException {
        if (!major.equals(Major.ART) && !major.equals(Major.ECONOMICS) && !major.equals(Major.MATH)) {
            throw new IllegalMajorException("Invalid major: " + major);
        }
    }
}
