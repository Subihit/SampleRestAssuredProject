package base;

import endpoints.HTTPMethod;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Logger.logInfo;
import static utils.Logger.logResponse;

public class CommonTest {

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        logInfo("Verify Status code is " + expectedStatusCode);
        assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void verifyResponseTime(Response response, int expectedResponseTime) {
        logInfo("Verify Response time is within " + expectedResponseTime);
        logInfo("API Response time is " + response.time());
        assertTrue(response.time() < expectedResponseTime);
    }

    public static Response sendRequest(HTTPMethod httpMethod, String URL) {
        logInfo("Send " + httpMethod + " request : " + URL);

        Response response = null;

        switch (httpMethod) {
            case GET:
                response = given()
                        .header("contentType", "application/json")
                        .when()
                        .get(URL);
                break;

            case PUT:
                break;

            case POST:

                break;

            case DELETE:
                break;

        }

        logResponse(response);

        return response;
    }

    public static Response sendRequest(HTTPMethod httpMethod, String URL, String payload) {
        logInfo("Send " + httpMethod + " request - " + URL);

        Response response = null;

        switch (httpMethod) {

            case PUT:
                break;

            case POST:

                given().header("content-type", "application/json")
                        .and().body(payload).
                        when().post(URL);

                break;

            case DELETE:
                break;

        }

        logInfo("Response body - " + response.then().log().body());

        return response;
    }

    public static String getPayLoad(String fileName) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/Requests/" + fileName));
            JSONObject jsonObject = (JSONObject) obj;

            String payload = jsonObject.toJSONString();
            System.out.println("Payload : " + payload);

            return payload;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "";
        }
    }


}
