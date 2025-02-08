package SMS;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String LOG_FILE = "student_management_system.log";
    private static final String LOG_FORMAT = "[%s] %s\n";
    private static final String LOG_DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true);
             PrintWriter printWriter = new PrintWriter(writer)) {
            String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(LOG_DATE_FORMAT));
            printWriter.printf(LOG_FORMAT, timestamp, message);
        } catch (IOException e) {
            System.out.println("Logging error: " + e.getMessage());
        }
    }
}
