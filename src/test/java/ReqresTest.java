import io.restassured.response.Response;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {
    @Test
    public void reqresTestFirst() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .statusCode(200)

        ;
    }

    @Test
    public void reqresTestSecond() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(200)

        ;
    }


    @Test
    public void reqresTestThird() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().body()
                .statusCode(404)

        ;
    }

    @Test
    public void reqresTestFourth() {
        given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().body()
                .statusCode(200)


        ;
    }


    @Test
    public void reqresTestFifth() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().body()
                .statusCode(200)


        ;
    }

    @Test
    public void reqresTestSixth() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().body()
                .statusCode(404)


        ;
    }



    @Test
    public void reqresTestSeventh() {
        Response response = given()
                .header(HTTP.CONTENT_TYPE, "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().body()
                .statusCode(201)
                .extract().response();
    }

    @Test
    public void reqresTestEighth() {
        given()
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void reqresTestNinth() {
        given()
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(200);

    }
    @Test
    public void reqresTestTenth() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(204);

    }


    @Test
    public void reqresTestEleventh() {
        Response response = given()
                .header(HTTP.CONTENT_TYPE, "application/json")
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }

    @Test
    public void reqresTestTwelfth() {
        Response response = given()
                .header(HTTP.CONTENT_TYPE, "application/json")
                .body("{\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(400)
                .body("error", equalTo("Missing password"))
                .extract().response();
        System.out.println(response.getBody().asString());
    }

    @Test
    public void reqresTestThirteenth() {
        Response response = given()
                .header(HTTP.CONTENT_TYPE, "application/json")
                .body("{\n" +
                        "    \"email\": \"peter@klaven\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().body()
                .statusCode(400)
                .body("error", equalTo("Missing password"))
                .extract().response();
        System.out.println(response.getBody().asString());
    }
    @Test
    public void reqresTestFourteenth() {
        Response response = given()
                .header(HTTP.CONTENT_TYPE, "application/json")
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();
        System.out.println(response.getBody().asString());
    }

    @Test
    public void reqresTestFifteenth() {
        given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .log().body()
                .statusCode(200)

        ;
    }
}
