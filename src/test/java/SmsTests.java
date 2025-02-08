import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmsTests {
    private static int idToEdit;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/students";
    }

    @Test
    @Order(1)
    public void testGetStudents() {
        Response response = given()
                .header("X-Api-Key", "")
                .when()
                .log().all()
                .get("/?page=2")
                .then()
                .statusCode(200)
                .extract().response();
        List<Map<String,Object>> students = response.jsonPath().getList("$");
        for (Map<String,Object> s : students) {
            System.out.println(s); // .get("title"));
        }
    }

    @Test
    @Order(2)
    public void testPostStudent() {
        String newGradStudent = "{ \"id\":17, " +
                "\"firstName\":\"Jaime\", " +
                "\"lastName\":\"Lannister\", " +
                "\"age\":\"37\", " +
                "\"major\":\"ART\", " +
                "\"email\":\"lannister@gmail.com\" " +
                "}";
        Response response = given()
                .header("X-Api-Key", "")
                .contentType(ContentType.JSON)
                .body(newGradStudent)
                .when()
                .post("/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        Map<String,Object> item = response.jsonPath().get();
        String id = item.get("id").toString();
        idToEdit = Integer.parseInt(id);
    }

    @Test
    @Order(3)
    public void testGetStudentById() {
        given()
                .header("X-Api-Key", "")
                .when()
                .get("/?id=" + idToEdit)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Order(4)
    public void testPutStudent() {
        String newUpdateStudent = "{ \"id\":17, " +
                "\"firstName\":\"Tywin\", " +
                "\"lastName\":\"Lannister\", " +
                "\"age\":\"58\", " +
                "\"major\":\"MATH\", " +
                "\"email\":\"lannister@gmail.com\" " +
                "}";

        given()
                .header("X-Api-Key", "")
                .contentType(ContentType.JSON)
                .body(newUpdateStudent)
                .when()
                .put("/")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Order(5)
    public void testPatchStudent() {
        String newEditStudent = "{ \"id\":18, " +
                "\"age\":\"30\" " +
                "}";

        Response response = given()
                .header("X-Api-Key", "")
                .contentType(ContentType.JSON)
                .body(newEditStudent)
                .when()
                .patch("/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        Map<String,Object> item = response.jsonPath().get();
        String id = item.get("id").toString();
        idToEdit = Integer.parseInt(id);
    }

//    @Test
//    @Order(6)
//    public void testDeleteStudent() {
//        given()
//                .header("X-Api-Key","")
//                .when()
//                .delete("/?id=" + idToEdit)
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
}
