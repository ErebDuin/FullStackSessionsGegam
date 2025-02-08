package Session16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassTask2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        List<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        Collections.sort(mergedList);

        System.out.println("Merged and sorted list: " + mergedList);
    }
}
