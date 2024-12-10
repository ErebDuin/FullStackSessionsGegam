package Session3;

import java.util.Scanner;

public class AgeCatigory {
    public static void main(String[] args) {
        // age < 13 = child
        // age from 13 to 19 = teenager
        // age from 20 to 59 = adult
        // age 60 and above = senior
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 13) {
            System.out.println("You are a child");
        } else if (age >= 13 && age <= 19) {
            System.out.println("You are a teenager");
        } else if (age >= 20 && age <= 59) {
            System.out.println("You are an adult");
        } else {
            System.out.println("Sorry, you are senior");
        }
        scanner.close();

        int num1 = 25;
        int num2 = 20;
        int result;
        result = (num1<num2) ? (num1+num2) : (num1-num2);
        System.out.println("Result: " + result);


    }
}
