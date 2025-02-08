package PilotSMS;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SmsJSON {
    public static void saveToJSON(List<Student> students) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("students.json")) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            System.out.println("An error occurred while saving to JSON: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadFromJSON() {
        Gson gson = new Gson();
        ArrayList<Student> students = new ArrayList<>();
        try (FileReader reader = new FileReader("students.json")) {
            Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
            students = gson.fromJson(reader, studentListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
