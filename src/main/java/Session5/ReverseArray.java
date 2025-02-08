package Session5;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] arr = {24, 54, 67, 32, 33, 47, 39};
//
//        System.out.print("Enter a number to find: ");
//        int numberToFind = scanner.nextInt();
//
//        boolean found = false;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == numberToFind) {
//                System.out.println("Number " + numberToFind + " found at index " + i);
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            System.out.println("Number " + numberToFind + " not found in the array.");

        int[] arrayOfNumbers = new int[10];
        int i;
        for (i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print("Enter a number: ");
            arrayOfNumbers[i] = scanner.nextInt();
        }
        System.out.println(arrayOfNumbers.length-1);
    }
}
