package PilotSMS;

import java.io.FileWriter;
import java.io.PrintWriter;

public class SmsLogger {
    public static void log(String message) {
        try (FileWriter fw = new FileWriter("log.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("[MESSAGE] " + message);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}
