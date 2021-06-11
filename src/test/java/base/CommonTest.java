package base;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Logger.logInfo;

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
}
