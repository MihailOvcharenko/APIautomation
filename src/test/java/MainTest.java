import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class MainTest {
    String testT = "Hello world";

    @Test
    public void test () {
        when().
                get("https://reqres.in/api/users/2").
                then().
                statusCode(200);
    }

}
