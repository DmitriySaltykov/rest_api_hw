package first_api_test;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class DeleteTest extends TestBase {
    @Test
    void DeleteRequestTest() {

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .when()
                .delete("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);

    }

}
