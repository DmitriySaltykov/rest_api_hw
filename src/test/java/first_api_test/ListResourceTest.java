package first_api_test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class ListResourceTest extends TestBase {
    @Test
    void ListResourseTest() {
        String createData = "{}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(createData)
                .when()
                .get("/unknown")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("page", is(1))
                .body("data.id", hasItems(1, 2, 3))
                .body("data.pantone_value", hasItems("15-5217"))
                .body("support.url", is(not(empty())));

    }


}
