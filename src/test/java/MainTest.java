import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MainTest {

    @Test
    public void test_get_list_users () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/users/2").

                then().
                statusCode(200);
    }
    @Test
    public void test_get_single_users () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/users?page=2").

                then().
                statusCode(200);
    }
    @Test
    public void test_get_single_user_not_found () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/unknown").

                then().
                statusCode(200);
    }
    @Test
    public void test_get_list_resource () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/unknown/2").

                then().
                statusCode(200);
    }
    @Test
    public void test_get_single_resource () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/users/23").

                then().
                statusCode(404);
    }
    @Test
    public void test_get_single_resource_not_found () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/unknown/23").

                then().
                statusCode(404);
    }
    @Test
    public void test_post_create () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"name\":\"morpheus\",\"job\":\"leader\"}").

                when().
                post("/api/users").

                then().
                statusCode(201);
    }
    @Test
    public void test_put_update () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"name\":\"morpheus\",\"job\":\"zion resident\"}").

                when().
                put("/api/users/2").

                then().
                statusCode(200);
    }
    @Test
    public void test_patch_update () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"name\":\"morpheus\",\"job\":\"zion resident\"}").

                when().
                patch("/api/users/2").

                then().
                statusCode(200);
    }
    @Test
    public void test_delete () {
        given().
                baseUri("https://reqres.in").

                when().
                delete("/api/users/2").

                then().
                statusCode(204);
    }
    @Test
    public void test_post_register_successful () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}").

                when().
                post("/api/register").

                then().
                statusCode(200);
    }
    @Test
    public void test_post_register_unsuccessful () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"email\": \"sydney@fife\"}").

                when().
                post("/api/register").

                then().
                statusCode(400);
    }
    @Test
    public void test_post_login_successful () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityscapes\"}").

                when().
                post("/api/login").

                then().
                statusCode(200);
    }
    @Test
    public void test_post_login_unsuccessful () {
        given().
                baseUri("https://reqres.in").
                contentType(ContentType.JSON).
                body("{\"email\": \"peter@klaven\"}").

                when().
                post("/api/login").

                then().
                statusCode(400);
    }
    @Test
    public void test_get_delayed_response () {
        given().
                baseUri("https://reqres.in").

                when().
                get("/api/users?delay=3").

                then().
                statusCode(200);
    }
}
