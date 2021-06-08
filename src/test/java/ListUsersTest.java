import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class ListUsersTest {

    String URL = "https://reqres.in";
    int statusCode = 200;

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = URL;
    }

    @Test
    public void getUsers() {
        given()
                .header("contentType", "application/json")
                .when()
                .get(URL)
                .then()
                .log()
                .all();

        System.out.println(" time " + get(URL).timeIn(TimeUnit.MILLISECONDS));
        given().when().get(URL).then().assertThat().statusCode(statusCode);
    }

    @Test
    public void addUsers() {
        String testNameParam = "test Name", testJobParam = "test Job";
        String payloadTemplate = getPayLoad("src/Requests/addUser.json");
        String payload = payloadTemplate.replace("NAME_PARAM", testNameParam).replace("JOB_PARAM", testJobParam);

        String endpoint = "/api/users";
        String URI = baseURI + endpoint;
        System.out.println("URI : " + URI);

        Response response = given().header("content-type", "application/json")
                .and().body(payload).
                        when().post(endpoint);

        System.out.println("Response body : ");
        response.then().log().body();

        verifyName(response, testNameParam);
        verifyJob(response, testJobParam);

    }

    public String getPayLoad(String filePath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;

            String payload = jsonObject.toJSONString();
            System.out.println("Payload : " + payload);

            return payload;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "";
        }
    }

    public void verifyName(Response response, String expectedName) {
        System.out.println("Verify Name");
        Assert.assertEquals(response.getBody().jsonPath().get("name"), expectedName);
    }

    public void verifyJob(Response response, String expectedName) {
        System.out.println("Verify job");
        Assert.assertEquals(response.getBody().jsonPath().get("job"), expectedName);
    }

}
