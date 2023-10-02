package first_api_test;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;

public class SingleUserTest extends TestBase {

    @Test
    void SingleUserTest() {
        String createData = "{}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(createData)
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.first_name",is(not(empty())))
                .body("data.last_name",is(not(empty())))
                .body("support.url", is(not(empty())));

    }
}
