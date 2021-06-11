package utils;

import endpoints.HTTPMethod;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utils.Logger.logInfo;
import static utils.Logger.logResponse;

public class Request {

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

            case DELETE:
                response = given()
                        .header("contentType", "application/json")
                        .when()
                        .delete(URL);
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
                response = given().header("content-type", "application/json")
                        .and().body(payload).
                                when().put(URL);
                break;

            case POST:
                response = given().header("content-type", "application/json")
                        .and().body(payload).
                                when().post(URL);
                break;
        }

        logResponse(response);

        return response;
    }
}
