package first_api_test;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class SingleUserTest extends TestBase {

    @Test
    void UserTest() {


        given()
                .log().method()
                .log().uri()
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"))
                .body("support.url", is("https://reqres.in/#support-heading"));

    }
}
