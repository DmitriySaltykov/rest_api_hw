package first_api_test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ListResourceTest extends TestBase {
    @Test
    void ResourceTest() {

        given()
                .log().method()
                .log().uri()
                .when()
                .get("/unknown")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("page", is(1))
                .body("data.id", hasItems(1, 2, 3))
                .body("data.pantone_value", hasItems("15-5217"))
                .body("support.url", is("https://reqres.in/#support-heading"));

    }


}
