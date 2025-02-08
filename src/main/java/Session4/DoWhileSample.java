package Session4;

import java.util.Scanner;

public class DoWhileSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        do {
            System.out.println("Enter a number: ");
            inputNumber = scanner.nextInt();
        } while (inputNumber != 0);
    }
}
