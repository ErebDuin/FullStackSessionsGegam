package Session13;

import java.util.HashMap;

public class HomeWorkAssignment {

//    public static int repCharacterCounter(String c) {
//        String str = "Title is the debut major-label studio album by American singer-songwriter Meghan Trainer (pictured)," +
//                "released on January 9, 2015. Initially a songwriter for other artists in 2013, Trainer signed with Epic" +
//                "Records the following year and began recording material she co-wrote with Kevin Kadish. They drew influence" +
//                "from retro-styled music as they were tired of chasing radio trends. Title includes \"All About That Bass\"," +
//                "which reached number one in 58 countries, and two other US Billboard Hot 100 top-10 singles: \"Lips AreMovin\"" +
//                "and \"Like I'm Gonna Lose You\".";
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == c.charAt(0)) {
//                count++;
//            }
//        }
//        return count;
//    }


    public static void main(String[] args) {
//        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
//        HashMap <String, Integer> wordCount = new HashMap<>();
//        for (String word : words) {
//            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//        }
//        System.out.println(wordCount);
//    }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a character: ");
//        String c = scanner.next();
        System.out.println(repCharacterCounter());
    }
//
    public static HashMap repCharacterCounter() {
        HashMap<Character, Integer> charCounter = new HashMap<>();
        String text = "Title is the debut major-label studio album by American singer-songwriter Meghan Trainer (pictured)," +
                "released on January 9, 2015. Initially a songwriter for other artists in 2013, Trainer signed with Epic" +
                "Records the following year and began recording material she co-wrote with Kevin Kadish. They drew influence" +
                "from retro-styled music as they were tired of chasing radio trends. Title includes \"All About That Bass\"," +
                "which reached number one in 58 countries, and two other US Billboard Hot 100 top-10 singles: \"Lips AreMovin\"" +
                "and \"Like I'm Gonna Lose You\".";
        for (char letter : text.toCharArray()) {
            charCounter.put(letter, charCounter.getOrDefault(letter, 0) + 1);
        }
        return charCounter;
    }
//    public static int repCharacterCounter(String c) {
//        String str = "Title is the debut major-label studio album by American singer-songwriter Meghan Trainer (pictured)," +
//                "released on January 9, 2015. Initially a songwriter for other artists in 2013, Trainer signed with Epic" +
//                "Records the following year and began recording material she co-wrote with Kevin Kadish. They drew influence" +
//                "from retro-styled music as they were tired of chasing radio trends. Title includes \"All About That Bass\"," +
//                "which reached number one in 58 countries, and two other US Billboard Hot 100 top-10 singles: \"Lips AreMovin\"" +
//                "and \"Like I'm Gonna Lose You\".";
//        int initialCount = str.length();
//        int replaceCount = str.replace(c, "").length();
//        return initialCount - replaceCount;
//    }
}
