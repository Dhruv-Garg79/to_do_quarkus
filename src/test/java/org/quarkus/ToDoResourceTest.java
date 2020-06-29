package org.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.Path;

import static io.restassured.RestAssured.given;

@QuarkusTest
@Path("/api/todo")
public class ToDoResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200);
    }

}