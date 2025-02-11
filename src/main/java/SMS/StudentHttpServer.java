package SMS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import SMS.custom_api_handlers.GraduationHandler;
import SMS.custom_api_handlers.StudentHandler;
import java.io.IOException;
import java.net.InetSocketAddress;

public class StudentHttpServer {
    private static final int PORT = 8084;
    private final StudentMaintenance studentMaintenance;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Runtime exitServer = Runtime.getRuntime();

    public StudentHttpServer(StudentMaintenance studentMaintenance) {
        this.studentMaintenance = studentMaintenance;
    }

    public static void main(String[] args) throws IOException {
        UtilityRepository utilityRepository = new UtilityRepositoryFile("/home/devuser/gegam/FullStackSessionsGegam/src/main/java/SMS/students.csv");
        StudentMaintenance studentMaintenance = new StudentMaintenance(utilityRepository);
        StudentHttpServer server = new StudentHttpServer(studentMaintenance);
        server.start();
    }

    public void start() throws IOException {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/students", new StudentHandler(objectMapper, studentMaintenance));
            server.createContext("/graduate", new GraduationHandler(objectMapper, studentMaintenance));
            server.setExecutor(null);
            server.start();
            System.out.println("HTTP server started on port " + PORT);
        } catch (IOException e) {
            System.out.println("Error starting HTTP server: " + e.getMessage());
        }
    }

    public void stop() {
        exitServer.exit(0);
    }
}
