package SMS.custom_api_handlers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import SMS.GraduationProcess;
import SMS.*;
import java.io.IOException;
import java.io.OutputStream;

public class GraduationHandler implements HttpHandler {
    private final ObjectMapper objectMapper;
    private final StudentMaintenance studentMaintenance;

    public GraduationHandler(ObjectMapper objectMapper, StudentMaintenance studentMaintenance) {
        this.objectMapper = objectMapper;
        this.studentMaintenance = studentMaintenance;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (Authentication.authenticate(exchange)) {
            return;
        }

        if (!exchange.getRequestMethod().equals("POST")) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        String requestBody = new String(exchange.getRequestBody().readAllBytes());
        JsonNode jsonNode = objectMapper.readTree(requestBody);
        int studentId = jsonNode.get("id").asInt();
        double gpa = jsonNode.get("gpa").asDouble();

        GraduateStudent newGradStudent = GraduationProcess.graduateStudentByIdAndGpa(studentId, gpa, studentMaintenance);

        String response = objectMapper.writeValueAsString(newGradStudent);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
