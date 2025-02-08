package Session9;

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 150) {
            throw new InvalidAgeException("age must be greater than 18 and less than 150");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age: ");
        int age = scanner.nextInt();

        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}
