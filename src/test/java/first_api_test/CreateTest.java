package first_api_test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;


public class CreateTest extends TestBase {
    @Test
    void successCreateUserTest() {
        String createData = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(createData)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .body("id", is(not(empty())))
                .body("createdAt", is(not(empty())));

    }

    @Test
    void createUserWithEmptyNameTest() {
        String createData = "{\"name\": \"\",\"job\": \"leader\"}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(createData)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("job", is("leader"))
                .body("id", is(not(empty())))
                .body("createdAt", is(not(empty())));

    }

    @Test
    void createUserWithEmptyJobTest() {
        String createData = "{\"name\": \"morpheus\",\"job\": \"\"}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(createData)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("id", is(not(empty())))
                .body("createdAt", is(not(empty())));

    }

    @Test
    void successUpdateUserTest() {
        String createData = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(createData)
                .when()
                .post("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .body("createdAt", is(not(empty())));
    }


}
