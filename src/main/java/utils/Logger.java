package utils;

import io.restassured.response.Response;
import org.testng.Reporter;

public class Logger {

    public static void logInfo(String message) {
        System.out.println(message);
        Reporter.log(message);
    }

    public static void logError(String message) {
        System.err.println(message);
        Reporter.log(message);
    }

    public static void logURL(String URL) {
        System.out.println("URL : " + URL);
        Reporter.log("URL : " + URL);
    }

    public static void logResponse(Response response) {
        logInfo("Response body :");
        response.then().log().body();
    }

}
