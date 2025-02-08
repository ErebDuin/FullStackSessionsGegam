package SMS;

import SMS.custom_exceptions.IllegalAgeException;
import SMS.custom_exceptions.IllegalEmailException;
import SMS.custom_exceptions.IllegalNameException;

/**
 * Utility class for validating student parameters.
 */
public final class StudentParameterValidation {

    /**
     * Validates the specified Name value.
     *
     * @param name the Name value to validate
     * @throws IllegalNameException if the Email value is invalid
     */
    public static void validateName(String name) throws IllegalNameException {
        if (!name.matches("^\\w{2,15}$")) {
            throw new IllegalNameException("Invalid name, try again");
        }
    }

    /**
     * Validates the specified Age value.
     *
     * @param age the Age value to validate
     * @throws IllegalAgeException if the Age value is invalid
     */
    public static void validateAge(int age) throws IllegalAgeException {
        if (!String.valueOf(age).matches ("^(1[8-9]|[2-9][0-9]|1[0-4][0-9]|150)$")) {
            throw new IllegalAgeException("Age must be between 18 and 150");
        }
    }

    /**
     * Validates the specified Email value.
     *
     * @param email the Email value to validate
     * @throws IllegalEmailException if the Email value is invalid
     */
    public static void validateEmail(String email) throws IllegalEmailException {
        if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]{2,15}$")) {
            throw new IllegalEmailException("Invalid email, try again");
        }
    }
}
