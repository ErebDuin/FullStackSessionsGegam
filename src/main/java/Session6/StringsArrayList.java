package Session6;

import java.util.ArrayList;

public class StringsArrayList {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Artem");
        strList.add("Vladyslav");
        strList.add("Eugen");
        strList.add("Gegam");
        strList.add("Nastia");
        strList.add("Elena");
        strList.add("Vitalii");

        System.out.println(strList);
        strList.remove(2);
        strList.remove("Nastia");
        System.out.println(strList.size());


    }
}
