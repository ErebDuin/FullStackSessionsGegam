package Session10;

import java.util.HashMap;
import java.util.Scanner;

public class RomanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Roman number: ");
        String romanNum = scanner.nextLine();
        System.out.println(convertRomanToNumber(romanNum));


    }

    public static int convertRomanToNumber(String romanNum) {
        int result = 0;

        HashMap<Character, Integer> numSet = new HashMap<>();
        numSet.put('I', 1);
        numSet.put('V', 5);
        numSet.put('X', 10);
        numSet.put('L', 50);
        numSet.put('C', 100);
        numSet.put('D', 500);
        numSet.put('M', 1000);

//        for (int i = 0; i < romanNum.length(); i++) {
        for (int i = romanNum.length() - 1; i >= 0; i--) {
            int current = numSet.get(romanNum.charAt(i));

            if (i < romanNum.length() - 1 && current < numSet.get(romanNum.charAt(i + 1))) {
                result = result - current;
            }
            else {
                result = result + current;
            }
        }
        return result;
    }
}
