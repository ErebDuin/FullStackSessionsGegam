package SMS.custom_api_handlers;

import SMS.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class StudentHandler implements HttpHandler {
    private final ObjectMapper objectMapper;
    private final StudentMaintenance studentMaintenance;

    public StudentHandler(ObjectMapper objectMapper, StudentMaintenance studentMaintenance) {
        this.objectMapper = objectMapper;
        this.studentMaintenance = studentMaintenance;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, X-Api-Key");

        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        if (!Authentication.authenticate(exchange)) {
            return;
    }
        String method = exchange.getRequestMethod();
        String response = "";

        switch (method) {
            case "GET":
                Logger.log("GET request received");
                response = handleGet(exchange);
                break;
            case "POST":
                response = handlePost(exchange);
                break;
            case "PUT":
                response = handlePut(exchange);
                break;
            case "PATCH":
                response = handlePatch(exchange);
                break;
            case "DELETE":
                response = handleDelete(exchange);
                break;
            default:
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                return;
        }

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String handleGet(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        int page = 0;
        int size = 5;

        if (query != null) {
            String[] queryParam = query.split("&");
            for (String param : queryParam) {
                String[] keyValue = param.split("=");
                if ("page".equals(keyValue[0])) {
                    page = Integer.parseInt(keyValue[1]);
                }
                if ("id".equals(keyValue[0])) {
                    Student student = studentMaintenance.getStudents().stream()
                            .filter(s -> s.getId() == Integer.parseInt(keyValue[1]))
                            .findFirst()
                            .orElse(null);
                    return student != null ? objectMapper.writeValueAsString(student) : "{\"error\": \"Student not found\"}";
                }
            }

            List<Student> students = studentMaintenance.getStudents();
            int fromIndex = page * size;
            int toIndex = Math.min(fromIndex + size, students.size());
            if (fromIndex >= students.size()) {
                return "[]";
            }
            List<Student> paginatedStudent = students.subList(fromIndex, toIndex);
            return objectMapper.writeValueAsString(paginatedStudent);
        }
        return "";
    }

    private String handlePost(HttpExchange exchange) throws IOException {
        String requestBody = new String(exchange.getRequestBody().readAllBytes());
        JsonNode jsonNode = objectMapper.readTree(requestBody);

        int id = studentMaintenance.getStudents().size() + 1;
        String email = jsonNode.get("email").asText();
        String firstName = jsonNode.get("firstName").asText();
        String lastName = jsonNode.get("lastName").asText();
        int age = jsonNode.get("age").asInt();
        Major major = Major.valueOf(jsonNode.get("major").asText());

        Student student = new UndergradStudent(id, email, firstName, lastName, age, major);
        studentMaintenance.addStudent(student);
        studentMaintenance.saveStudents();
        return objectMapper.writeValueAsString(student);
    }

    private String handlePut(HttpExchange exchange) throws IOException {
        String requestBody = new String(exchange.getRequestBody().readAllBytes());
        JsonNode jsonNode = objectMapper.readTree(requestBody);

        try {
            int id = jsonNode.get("id").asInt();
            String email = jsonNode.get("email").asText();
            String firstName = jsonNode.get("firstName").asText();
            String lastName = jsonNode.get("lastName").asText();
            int age = jsonNode.get("age").asInt();
            Major major = Major.valueOf(jsonNode.get("major").asText());

            Student student = studentMaintenance.getStudents().stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (student != null) {
                student.setEmail(email);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setMajor(major.toString());
                studentMaintenance.saveStudents();
                return objectMapper.writeValueAsString(student);
            } else {
                return "{\"error\": \"Student not found\"}";
            }
        } catch (Exception e) {
            Logger.log("Error in PUT: " + e.getMessage());
        }
        return "";
    }

    private String handlePatch(HttpExchange exchange) throws IOException {
        String requestBody = new String(exchange.getRequestBody().readAllBytes());
        JsonNode jsonNode = objectMapper.readTree(requestBody);

        int id = jsonNode.get("id").asInt();
        Student student = studentMaintenance.getStudents().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student != null) {
            if (jsonNode.has("email")) {
                student.setEmail(jsonNode.get("email").asText());
            }
            if (jsonNode.has("firstName")) {
                student.setFirstName(jsonNode.get("firstName").asText());
            }
            if (jsonNode.has("lastName")) {
                student.setLastName(jsonNode.get("lastName").asText());
            }
            if (jsonNode.has("age")) {
                student.setAge(jsonNode.get("age").asInt());
            }
            if (jsonNode.has("major")) {
                student.setMajor(jsonNode.get("major").asText());
            }
            studentMaintenance.saveStudents();
            return objectMapper.writeValueAsString(student);
        } else {
            return "{\"error\": \"Student not found\"}";
        }
    }

    private String handleDelete(HttpExchange exchange) {
        String query = exchange.getRequestURI().getQuery();
        int id = Integer.parseInt(query.split("=")[1]);
        studentMaintenance.deleteStudent(id);
        studentMaintenance.saveStudents();
        return "{\"message\": \"Deleted student with ID: " + id + "\"}";
    }
}
