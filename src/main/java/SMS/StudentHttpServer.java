package SMS;

import SMS.custom_api_handlers.*;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class StudentHttpServer {
    private static final int PORT = 8080;
    private final StudentMaintenance studentMaintenance;
    private final Runtime exitServer = Runtime.getRuntime();

    public StudentHttpServer(StudentMaintenance studentMaintenance) {
        this.studentMaintenance = studentMaintenance;
    }

    public static void main(String[] args) throws IOException {
        UtilityRepository utilityRepository = new UtilityRepositoryFile("/Users/gegam/IdeaProjects/FullStackSessionsGegam/src/main/java/SMS/students.csv");
        StudentMaintenance studentMaintenance = new StudentMaintenance(utilityRepository);
        StudentHttpServer server = new StudentHttpServer(studentMaintenance);
        server.start();
    }

    public void start() throws IOException {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/students", new StudentHandler(studentMaintenance));
            server.createContext("/graduate", new GraduationHandler(studentMaintenance));
            server.createContext("/authenticate", new AuthenticationHandler());
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
