package SMS.custom_api_handlers;

import SMS.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class AuthenticationHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, token");

        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        if (!"POST".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            return;
        }

        String requestBody = new String(exchange.getRequestBody().readAllBytes());
        JsonNode jsonNode = new ObjectMapper().readTree(requestBody);

        String login = jsonNode.get("login").asText();
        String password = jsonNode.get("password").asText();

        if (Authentication.validateCredentials(login, password)) {
            String token = UUID.randomUUID().toString();
            Authentication.storeToken(token);

            String response = "{\"token\": \"" + token + "\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(401, -1); // Unauthorized
        }

        OutputStream os = exchange.getResponseBody();
        os.close();
    }
}
