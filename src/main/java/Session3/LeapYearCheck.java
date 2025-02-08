package Session3;

import java.util.Scanner;

public class LeapYearCheck {
    public static void main(String[] args) {
        // Leap year
        // divisible by 4
        // divisible by 100
        // divisible by 400

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = scanner.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a leap year");
                } else {
                    System.out.println(year + " is not a leap year");
                }
            } else {
                System.out.println(year + " is a leap year");
            }
        } else {
            System.out.println(year + " is not a leap year");
        }
        scanner.close();
    }
}
